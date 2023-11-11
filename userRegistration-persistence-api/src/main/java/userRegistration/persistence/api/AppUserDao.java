package userRegistration.persistence.api;

import userRegistration.domain.AppUser;

public interface AppUserDao {

    AppUser create(AppUser user);

}
