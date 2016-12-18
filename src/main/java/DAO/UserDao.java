package DAO;

import domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * User:Anton_Iehorov
 * Date: 12/16/2016
 * Time: 3:59 PM
 */
public class UserDao implements ICrudDAO {
    private List<User> users = new ArrayList<>();

    public UserDao() {
        initUsers();
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void removeUser(int id) {

    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void updateUser() {

    }

    private void initUsers() {
        users.add(new User("login", "password", "email",
                "123", "name", "surname"));
        users.add(new User("log", "pass", "email",
                "123", "name", "surname"));
    }
}
