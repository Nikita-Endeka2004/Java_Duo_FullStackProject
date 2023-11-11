package userRegistration.persistence.in.mariadb;

import userRegistration.domain.AppUser;
import userRegistration.persistence.api.AppUserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AppUserDaoImpl implements AppUserDao {

    private Connection connection;

    public void setConnection(Connection connection){
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    private static final String INSERT_USER_QUERY = "insert into users (surname, name, gender, email, password) values (?, ?, ?, ?, ?)";

    public AppUser create(AppUser user){
        try{
            PreparedStatement statement = connection.prepareStatement(INSERT_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,user.getSurname());
            statement.setString(2,user.getName());
            statement.setString(3,user.getGender());
            statement.setString(4,user.getEmail());
            statement.setString(5,user.getPassword());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()){
                user.setId(generatedKeys.getLong(1));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

}
