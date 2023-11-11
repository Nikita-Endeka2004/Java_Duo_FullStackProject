package userRegistration.persistence.in.mariadb;

import userRegistration.domain.Author;
import userRegistration.domain.Book;
import userRegistration.persistence.api.CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class BookCRUD <T extends Book> implements CRUD<T> {
    private Connection connection;
    public BookCRUD(Connection connection){
        this.connection = connection;
    }
    private static final String INSERT_USER_QUERY = "insert into books (title, author_id, published_year) values (?, ?, ?)";
    @Override
    public T create(T book){
        try(
                PreparedStatement statement = connection.prepareStatement(INSERT_USER_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, book.getTitle());
            statement.setLong(2, book.getAuthorId());
            statement.setLong(3, book.getPublicationYear());
            statement.executeUpdate();
            ResultSet generatedKey = statement.getGeneratedKeys();
            if(generatedKey.next()){
                book.setBookId(generatedKey.getLong(1));
            }
        }catch (SQLException e){
            System.err.println("There was a problem to insert book into the database");
            e.printStackTrace();
        }
        return book;
    }
    @Override
    public Collection<T> create(Collection<T> books){
        Collection<T>bookCollection = new ArrayList<>();
        try(
                PreparedStatement statement = connection.prepareStatement(INSERT_USER_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            for(Book book:books) {
                statement.setString(1, book.getTitle());
                statement.setLong(2, book.getAuthorId());
                statement.setLong(3, book.getPublicationYear());
                statement.executeUpdate();
                ResultSet generatedKey = statement.getGeneratedKeys();
                if (generatedKey.next()) {
                    book.setBookId(generatedKey.getLong(1));
                    bookCollection.add((T) book);
                }
            }
        }catch (SQLException e){
            System.err.println("There was a problem to insert book into the database");
            e.printStackTrace();
        }
        return bookCollection;
    }
    private static final String READ_BOOK_QUERY = "select * from book where book_id = '%d'";
    @Override
    public T read(int id){
        T book = null;
        try(
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(String.format(READ_BOOK_QUERY, id));
            while(resultSet.next()){
                book = (T) new Book();
                book.setBookId(resultSet.getLong("book_id"));
                book.setTitle(resultSet.getString("title"));
                book.setPublicationYear(resultSet.getInt("published_year"));
                book.setAuthorId(resultSet.getInt("author_id"));
            }
        }catch (Exception e){
            System.err.println("There was a problem to read book from the database");
            e.printStackTrace();
        }
        return book;
    }
    private static final String UPDATE_BOOK_QUERY = "update authors set title = ?, published_year = ? where book_id = ?";
    @Override
    public void update(T book){
        try(
                PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK_QUERY)
        ){
            statement.setString(1,book.getTitle());
            statement.setInt(2,book.getPublicationYear());
            statement.setLong(3,book.getBookId());
            statement.executeUpdate();
        } catch (SQLException e){
            System.err.println("There was a problems to update book in the database");
            e.printStackTrace();
        }
    }
    @Override
    public void update(Collection<T> books){
        try(
                PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK_QUERY)
        ){
            for(Book book:books){
                statement.setString(1,book.getTitle());
                statement.setInt(2,book.getPublicationYear());
                statement.setLong(3,book.getBookId());
                statement.executeUpdate();
            }
        }catch (SQLException e){
            System.err.println("There was a problems to update book in the database");
            e.printStackTrace();
        }
    }
    private static final String DELETE_BOOK_QUERY = "delete from books where book_id = ?";
    @Override
    public void delete(T book) {
        try(
                PreparedStatement statement = connection.prepareStatement(DELETE_BOOK_QUERY)
        ){
            statement.setLong(1,book.getBookId());
            statement.executeUpdate();
        } catch (SQLException e){
            System.err.println("There was a problem to delete book from the database");
            e.printStackTrace();
        }
    }
}
