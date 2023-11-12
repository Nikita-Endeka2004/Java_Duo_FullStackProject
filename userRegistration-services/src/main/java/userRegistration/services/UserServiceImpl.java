package userRegistration.services;

import userRegistration.domain.AppUser;
import userRegistration.domain.dto.AppUserCreateDto;
import userRegistration.domain.dto.AppUserViewDto;
import userRegistration.persistence.in.mariadb.AppUserDaoImpl;
import userRegistration.persistence.in.mariadb.DBManager;
import userRegistration.services.converter.AppUserConverter;
import userRegistration.persistence.in.mariadb.config.PropertiesManager;
import userRegistration.services.validator.UserValidator;
import userRegistration.services.validator.UserValidatorImpl;
import userRegistration.services_api.UserService;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private PropertiesManager propertiesManager = new PropertiesManager();
    private UserValidator userValidator = new UserValidatorImpl();

    @Override
    public AppUserViewDto registerUser(AppUserCreateDto createDto) {
        AppUserViewDto appUserViewDto = new AppUserViewDto();
        try (Connection connection = DBManager.getConnection(propertiesManager.getApplicationProperties());
        ) {
            AppUserDaoImpl appUserDao = new AppUserDaoImpl();
            appUserDao.setConnection(connection);
            AppUserConverter appUserConverter = new AppUserConverter();
            userValidator.validateNewUser(createDto);
            AppUser user = appUserConverter.asAppUser(createDto);
            user = appUserDao.create(user);
            appUserViewDto = appUserConverter.asUserDto(user);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return appUserViewDto;
    }
}
