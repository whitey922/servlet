package validator;

import DAO.UserDao;
import domain.User;

/**
 * User: IMPERIVM
 * Date: 17.12.2016
 * Time: 13:35
 */
public class UserValidationAuth {
    public static boolean isUserAuth(UserDao userDao, String login, String password) {

        for (User user : userDao.getUsers()) {
            if(user.getLogin().equals(login)&&user.getPassword().equals(password)) return true;
        }
        return false;
    }
}
