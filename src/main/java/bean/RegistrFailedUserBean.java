package bean;

import domain.User;

/**
 * User: IMPERIVM
 * Date: 18.12.2016
 * Time: 14:11
 */
public class RegistrFailedUserBean extends User {
    /***
     *  @param login user's login
     * @param password user's password
     * @param email user's email
     * @param phone user's phone
     * @param name user's name
     * @param surname user's surname
     */
    public RegistrFailedUserBean(String login, String password, String email, String phone, String name, String surname) {
        super(login, password, email, phone, name, surname);
    }
}
