package service;

import DAO.UserDao;
import domain.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

/**
 * User:Anton_Iehorov
 * Date: 12/21/2016
 * Time: 11:44 AM
 */
public class ServiceTest {
    private UserDao userDao;
    private UserService userService;
    private User user;

    @BeforeClass
    public void setUp() {
        userDao = mock(UserDao.class);
        userService = new UserService(userDao);
    }

    @Test
    public void addUser() {
        user = new User();
        user.setLogin("login");
        user.setPassword("password");
//        verify(userDao.getUser("login", "password").e
        when(userService.getUser("login", "password")).thenReturn(user);
    }

    @Test
    public void existUser() {
        user = new User();
        user.setLogin("login");
        user.setPassword("password");
        when(userService.exist("login")).thenReturn(true);
    }

    @Test
    public void noExistUser() {
        user = new User();
        user.setLogin("logidgfn");
        user.setPassword("password");
        when(userService.exist("login")).thenReturn(false);
    }

    @Test
    public void register() {
        user = new User();
        user.setLogin("login");
        user.setPassword("password");

        when(userService.register(user)).thenReturn(user);
    }
}
