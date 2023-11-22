package userRegistration.services;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import userRegistration.domain.AppUser;
import userRegistration.domain.dto.AppUserCreateDto;
import userRegistration.domain.dto.AppUserViewDto;
import userRegistration.persistence.in.mariadb.AppUserDaoImpl;
import userRegistration.services.exceptions.ValidationException;
import userRegistration.services_api.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Mock
    private AppUserDaoImpl appUserDao = new AppUserDaoImpl();

    @InjectMocks
    private UserService sut = new UserServiceImpl();
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void registerUser() {
        //GIVEN
        String name = "John";
        String surname = "Doe";
        String gender = "man";
        String email = "doe@ukr.net";
        String password = "123";
        AppUserCreateDto createDto = new AppUserCreateDto(name, surname, gender, email, password);
        AppUserViewDto appUserViewDto = new AppUserViewDto(1L, name, surname, gender, email);
        AppUser predefinedAppUser = new AppUser(1L, name, surname, gender, email, password);
        AppUser user = new AppUser(1L, name, surname, gender, email, password);
        Mockito.when(appUserDao.create(user)).thenReturn(predefinedAppUser);
        //WHEN
        AppUserViewDto result = sut.registerUser(createDto);
        //THEN
        Assert.assertNotNull(result);
        Assert.assertEquals(appUserViewDto, result);
        Mockito.verify(appUserDao, Mockito.times(1)).create(user);
    }

    @Test
    public void login() {
        //GIVEN
        String name = "John";
        String surname = "Doe";
        String gender = "man";
        String email = "doe@ukr.net";
        String password = "123";
        String wrongPassword = "321";
        AppUser user = new AppUser(1L, name, surname, gender, email, password);
        AppUserViewDto expected = new AppUserViewDto(1L, name, surname, gender, email);
        Mockito.when(appUserDao.getByEmail(email)).thenReturn(user);
        //WHEN
        AppUserViewDto result = sut.login(email, password);

        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("Wrong password");
        AppUserViewDto result1 = sut.login(email, wrongPassword);

        //THEN
        Assert.assertNotNull(result);
        Assert.assertEquals(expected, result);
        Mockito.verify(appUserDao, Mockito.times(1)).getByEmail(email);
    }
}