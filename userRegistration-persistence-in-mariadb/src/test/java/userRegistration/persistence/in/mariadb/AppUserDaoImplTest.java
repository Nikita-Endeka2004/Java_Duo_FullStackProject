package userRegistration.persistence.in.mariadb;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import userRegistration.domain.AppUser;
import userRegistration.persistence.in.mariadb.config.PropertiesManager;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class AppUserDaoImplTest {

    private PropertiesManager propertiesManager = new PropertiesManager();
    @Before
    public void setUp() throws Exception{

    }
    @After
    public void tearDown() throws Exception{

    }
    @Test
    public void create() throws SQLException {
        Connection connection = DBManager.getConnection(propertiesManager.getApplicationProperties());
        connection.setAutoCommit(false);
        try{
            String name = "John";
            String surname = "Doe";
            String gender = "man";
            String email = "doe@ukr.net";
            String password = "123";
            AppUser user = new AppUser(1l, name, surname, gender, email, password);
            AppUserDaoImpl appUserDao = new AppUserDaoImpl();
            appUserDao.setConnection(connection);
            AppUser resultUser = appUserDao.create(user);
            Assert.assertNotNull(resultUser);
            assertEquals(user, resultUser);
        }finally {
            connection.rollback();
            connection.close();
        }
    }

}