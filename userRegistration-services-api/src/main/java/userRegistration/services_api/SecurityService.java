package userRegistration.services_api;

import userRegistration.domain.AppUser;

public interface SecurityService {
    boolean isCorrectPassword(AppUser user, String password);
}
