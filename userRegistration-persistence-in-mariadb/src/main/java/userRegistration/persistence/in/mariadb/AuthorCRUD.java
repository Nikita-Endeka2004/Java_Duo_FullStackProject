package userRegistration.persistence.in.mariadb;

import userRegistration.domain.Author;
import userRegistration.persistence.api.CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class AuthorCRUD <T extends Author> implements CRUD <T> {
    private Connection connection;
    public AuthorCRUD(Connection connection){
        this.connection = connection;
    }
    private static final String INSERT_USER_QUERY = "insert into author (first_name, last_name) values (?, ?)";
    @Override
    public T create(T author){
        try(
            PreparedStatement statement = connection.prepareStatement(INSERT_USER_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, author.getFirstName());
            statement.setString(2, author.getLastName());
            statement.executeUpdate();
            ResultSet generatedKey = statement.getGeneratedKeys();
            if(generatedKey.next()){
                author.setAuthorId(generatedKey.getLong(1));
            }
        }catch (SQLException e){
            System.err.println("There was a problem to insert author into the database");
            e.printStackTrace();
        }
        return author;
    }
    @Override
    public Collection<T> create(Collection<T> authors){
        Collection<T>authorCollection = new ArrayList<>();
        try(
                PreparedStatement statement = connection.prepareStatement(INSERT_USER_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            for(Author author:authors) {
                statement.setString(1, author.getFirstName());
                statement.setString(2, author.getLastName());
                statement.executeUpdate();
                ResultSet generatedKey = statement.getGeneratedKeys();
                if (generatedKey.next()) {
                    author.setAuthorId(generatedKey.getLong(1));
                    authorCollection.add((T) author);
                }
            }
        }catch (SQLException e){
            System.err.println("There was a problem to insert author into the database");
            e.printStackTrace();
        }
        return authorCollection;
    }
    private static final String READ_AUTHOR_QUERY = "select * from authors where author_id = '%d'";
    @Override
    public T read(int id){
        T author = null;
        try(
                Statement statement = connection.createStatement()
                ) {
            ResultSet resultSet = statement.executeQuery(String.format(READ_AUTHOR_QUERY, id));
            while(resultSet.next()){
                author = (T) new Author();
                author.setAuthorId(resultSet.getLong("author_id"));
                author.setFirstName(resultSet.getString("first_name"));
                author.setLastName(resultSet.getString("last_name"));
            }
        }catch (Exception e){
            System.err.println("There was a problem to read author from the database");
            e.printStackTrace();
        }
        return author;
    }
    private static final String UPDATE_AUTHOR_QUERY = "update authors set first_name = ?, last_name = ? where author_id = ?";
    @Override
    public void update(T author){
        try(
                PreparedStatement statement = connection.prepareStatement(UPDATE_AUTHOR_QUERY)
                ){
            statement.setString(1,author.getFirstName());
            statement.setString(2,author.getLastName());
            statement.setLong(3,author.getAuthorId());
            statement.executeUpdate();
        } catch (SQLException e){
            System.err.println("There was a problems to update author in the database");
            e.printStackTrace();
        }
    }
    @Override
    public void update(Collection<T> authors){
        try(
                PreparedStatement statement = connection.prepareStatement(UPDATE_AUTHOR_QUERY)
                ){
            for(Author author:authors){
                statement.setString(1,author.getFirstName());
                statement.setString(2,author.getLastName());
                statement.setLong(3,author.getAuthorId());
                statement.executeUpdate();
            }
        }catch (SQLException e){
            System.err.println("There was a problems to update author in the database");
            e.printStackTrace();
        }
    }
    private static final String DELETE_AUTHOR_QUERY = "delete from authors where author_id = ?";
    @Override
    public void delete(T author) {
        try(
                PreparedStatement statement = connection.prepareStatement(DELETE_AUTHOR_QUERY)
                ){
            statement.setLong(1,author.getAuthorId());
            statement.executeUpdate();
        } catch (SQLException e){
            System.err.println("There was a problem to delete author from the database");
            e.printStackTrace();
        }
    }
}
