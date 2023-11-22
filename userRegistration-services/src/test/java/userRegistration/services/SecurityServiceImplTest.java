package userRegistration.services;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import userRegistration.domain.AppUser;
import userRegistration.services.exceptions.ApplicationException;
import userRegistration.services_api.SecurityService;

import static org.junit.Assert.*;

public class SecurityServiceImplTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void isCorrectPassword() {
        //GIVEN
        String name = "John";
        String surname = "Doe";
        String gender = "man";
        String email = "doe@ukr.net";
        String password = "123";
        String wrongPassword = "321";
        AppUser user = new AppUser(1L, name, surname, gender, email, password);
        AppUser userWithNullPassword = new AppUser(1L, name, surname, gender, email, null);
        SecurityService securityService = new SecurityServiceImpl();

        //WHEN
        Boolean result = securityService.isCorrectPassword(user, password);
        Boolean falseResult = securityService.isCorrectPassword(user, wrongPassword);

//        expectedException.expect(ApplicationException.class);
//        expectedException.expectMessage("Email or password is wrong");
//        securityService.isCorrectPassword(userWithNullPassword, password);
//
//        expectedException.expect(ApplicationException.class);
//        expectedException.expectMessage("Email or password is wrong");
//        securityService.isCorrectPassword(null, password);

        //THEN
        Assert.assertNotNull(result);
        Assert.assertEquals(true, result);
        Assert.assertNotNull(falseResult);
        Assert.assertEquals(false, falseResult);
    }
}