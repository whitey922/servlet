package domain;

/**
 * User:Anton_Iehorov
 * Date: 12/15/2016
 * Time: 10:36 AM
 */
public class User {
    private String id;
    private String login;
    private String password;
    private String email;
    private String phone;
    private String name;
    private String surname;

    /***
     *
     * @param login user's login
     * @param password user's password
     * @param email user's email
     * @param phone user's phone
     * @param name user's name
     * @param surname user's surname
     */
    public User(String login, String password, String email, String phone, String name, String surname) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.surname = surname;
    }

    public User(String id, String login, String password, String email, String phone, String name, String surname) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.surname = surname;
    }

    /***
     *
     * @return user's login
     */
    public String getLogin() {
        return login;
    }

    /***
     *
     * @return user's password
     */
    public String getPassword() {
        return password;
    }

    /***
     *
     * @return user's email
     */
    public String getEmail() {
        return email;
    }

    /***
     *
     * @return user's phone
     */
    public String getPhone() {
        return phone;
    }

    /***
     *
     * @return user's name
     */
    public String getName() {
        return name;
    }

    /***
     *
     * @return user's surname
     */
    public String getSurname() {
        return surname;
    }


}
