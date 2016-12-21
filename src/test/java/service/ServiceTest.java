package service;

import DAO.UserDao;
import domain.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * User:Anton_Iehorov
 * Date: 12/21/2016
 * Time: 11:44 AM
 */
public class ServiceTest {
    private UserDao userDao;
    private UserService userService;

    @BeforeClass
    public void setUp() {
        userDao = mock(UserDao.class);
        userService = new UserService(userDao);
    }

    @Test
    public void getUserByLoginAndPassword() {
        userService.getUser("login", "password");
        verify(userDao).getUser("login", "password");
    }

    @Test
    public void checkUserExist() {
        Assert.assertEquals(userService.exist("login"), false);
    }

    @Test
    public void registerUser() {
        User user = new User();
        user.setLogin("testuser")
                .setSurname("testuser")
                .setPassword("testuser")
                .setName("testuser")
                .setPhone("45645")
                .setEmail("testuser@testuser");
        userService.register(user);
        verify(userDao).getUser("testuser");
    }
}
