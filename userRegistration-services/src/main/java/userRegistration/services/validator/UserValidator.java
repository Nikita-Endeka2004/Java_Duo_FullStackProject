package userRegistration.services.validator;

import userRegistration.domain.dto.AppUserCreateDto;

public interface UserValidator {
    void validateUserCredentials(String email,String password);
    void validateNewUser(AppUserCreateDto createDto);
}
