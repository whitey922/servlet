package service;

import domain.User;

/**
 * User:Anton_Iehorov
 * Date: 12/20/2016
 * Time: 10:51 AM
 */
public interface IUserService {
    User getUser(String login, String password);
    User register(User user);
    boolean exist(String login);
}
