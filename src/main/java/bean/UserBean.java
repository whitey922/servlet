package bean;

import java.io.Serializable;

/**
 * User: IMPERIVM
 * Date: 17.12.2016
 * Time: 21:46
 */
public class UserBean implements Serializable {
    private String login;

    public UserBean(String name) {
        this.login = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
