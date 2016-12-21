package DAO;

import domain.User;

/**
 * User:Anton_Iehorov
 * Date: 12/16/2016
 * Time: 3:52 PM
 */
public interface ICrudDAO {
    User addUser(User user);

    void removeUser(int id);

    User getUser(String login, String password);
    boolean getUser(String login);

    void updateUser();
}
