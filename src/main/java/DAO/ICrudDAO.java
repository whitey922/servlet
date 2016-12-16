package DAO;

import domain.User;

import java.util.List;

/**
 * User:Anton_Iehorov
 * Date: 12/16/2016
 * Time: 3:52 PM
 */
public interface ICrudDAO {
    void addUser(User user);

    void removeUser(int id);

    List<User> getUsers();

    void updateUser();
}
