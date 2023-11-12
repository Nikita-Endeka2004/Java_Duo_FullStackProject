package userRegistration.services.validator;

import org.apache.commons.lang3.StringUtils;
import userRegistration.domain.dto.AppUserCreateDto;
import userRegistration.services.exceptions.ValidationException;

public class UserValidatorImpl implements UserValidator{
    @Override
    public void validateUserCredentials(String email, String password){
        if(StringUtils.isEmpty(email) || StringUtils.isEmpty(password)){
            throw new ValidationException("Invalid credentials: " + email);
        }
    }
    @Override
    public void validateNewUser(AppUserCreateDto createDto){
        validateUserCredentials(createDto.getEmail(), createDto.getPassword());
        if(StringUtils.isEmpty(createDto.getName())){
            throw new ValidationException("Invalid user name: " + createDto.getName());
        }
    }
}
