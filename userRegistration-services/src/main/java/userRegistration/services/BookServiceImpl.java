package userRegistration.services;

import userRegistration.domain.Book;
import userRegistration.persistence.in.mariadb.BookCRUD;
import userRegistration.persistence.in.mariadb.DBManager;
import userRegistration.persistence.in.mariadb.config.PropertiesManager;
import userRegistration.services_api.BookService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class BookServiceImpl implements BookService {
    private PropertiesManager propertiesManager = new PropertiesManager();

    @Override
    public Collection<Book> readBooks() {
        Collection<Book> books = new ArrayList<>();
        try(Connection connection = DBManager.getConnection(propertiesManager.getApplicationProperties());
        ) {
            BookCRUD bookCRUD = new BookCRUD(connection);
            books = bookCRUD.read();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return books;
    }
}
