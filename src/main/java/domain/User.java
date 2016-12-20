package domain;

/**
 * User:Anton_Iehorov
 * Date: 12/15/2016
 * Time: 10:36 AM
 */
public class User {
    private int id;
    private String login;
    private String password;
    private String email;
    private String phone;
    private String name;
    private String surname;

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    /***
     *
     * @return user's login
     */
    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    /***
     *
     * @return user's password
     */
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    /***
     *
     * @return user's email
     */
    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    /***
     *
     * @return user's phone
     */
    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    /***
     *
     * @return user's name
     */
    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    /***
     *
     * @return user's surname
     */
    public String getSurname() {
        return surname;
    }

    public User setSurname(String surname) {
        this.surname = surname;
        return this;
    }


}
