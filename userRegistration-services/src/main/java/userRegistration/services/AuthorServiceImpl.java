package userRegistration.services;

import userRegistration.domain.Author;
import userRegistration.persistence.in.mariadb.AuthorCRUD;
import userRegistration.persistence.in.mariadb.DBManager;
import userRegistration.persistence.in.mariadb.config.PropertiesManager;
import userRegistration.services_api.AuthorService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class AuthorServiceImpl implements AuthorService {
    private PropertiesManager propertiesManager = new PropertiesManager();

    @Override
    public Collection<Author> readAuthors() {
        Collection<Author> authors = new ArrayList<>();
        try(Connection connection = DBManager.getConnection(propertiesManager.getApplicationProperties());
        ) {
            AuthorCRUD authorCRUD = new AuthorCRUD(connection);
            authors = authorCRUD.read();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return authors;
    }
}
