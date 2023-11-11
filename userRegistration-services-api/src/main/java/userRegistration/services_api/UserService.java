package userRegistration.services_api;

import userRegistration.domain.dto.AppUserCreateDto;
import userRegistration.domain.dto.AppUserViewDto;

public interface UserService {
    AppUserViewDto registerUser(AppUserCreateDto createDto);
}
