package service;

import DAO.ICrudDAO;
import domain.User;

import java.util.Objects;

/**
 * User:Anton_Iehorov
 * Date: 12/20/2016
 * Time: 10:49 AM
 */
public class UserService implements IUserService {
    private ICrudDAO iCrudDAO;

    public UserService(ICrudDAO iCrudDAO) {
        this.iCrudDAO = Objects.requireNonNull(iCrudDAO);
    }

    @Override
    public User getUser(String login, String password) {
        return iCrudDAO.getUser(login, password);
    }

    @Override
    public synchronized User register(User user) {
        return iCrudDAO.addUser(user);
    }

    @Override
    public boolean exist(String login) {
        return iCrudDAO.getUser(login);
    }

}
