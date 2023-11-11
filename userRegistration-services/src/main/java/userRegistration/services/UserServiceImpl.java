package userRegistration.services;

import userRegistration.domain.AppUser;
import userRegistration.domain.dto.AppUserCreateDto;
import userRegistration.domain.dto.AppUserViewDto;
import userRegistration.persistence.in.mariadb.AppUserDaoImpl;
import userRegistration.persistence.in.mariadb.DBManager;
import userRegistration.services.converter.AppUserConverter;
import userRegistration.persistence.in.mariadb.config.PropertiesManager;
import userRegistration.services_api.UserService;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private PropertiesManager propertiesManager = new PropertiesManager();

    @Override
    public AppUserViewDto registerUser(AppUserCreateDto createDto) {
        AppUserViewDto appUserViewDto = new AppUserViewDto();
        try (Connection connection = DBManager.getConnection(propertiesManager.getApplicationProperties());
        ) {
            AppUserDaoImpl appUserDao = new AppUserDaoImpl();
            appUserDao.setConnection(connection);
            AppUserConverter appUserConverter = new AppUserConverter();
            AppUser user = appUserConverter.asAppUser(createDto);
            user = appUserDao.create(user);
            appUserViewDto = appUserConverter.asUserDto(user);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return appUserViewDto;
    }
}
