package userRegistration.services.converter;

import userRegistration.domain.AppUser;
import userRegistration.domain.dto.AppUserCreateDto;
import userRegistration.domain.dto.AppUserViewDto;

public class AppUserConverter {
    public AppUserViewDto asUserDto(AppUser user){
        AppUserViewDto dto = new AppUserViewDto();
        dto.setGender(user.getGender());
        dto.setId(user.getId());
        dto.setSurname(user.getSurname());
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        return dto;
    }
    public AppUser asAppUser(AppUserCreateDto createDto){
        AppUser user = new AppUser();
        user.setEmail(createDto.getEmail());
        user.setPassword(createDto.getPassword());
        user.setName(createDto.getName());
        user.setSurname(createDto.getSurname());
        user.setGender(createDto.getGender());
        return user;
    }
}
