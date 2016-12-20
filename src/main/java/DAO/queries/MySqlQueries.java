package DAO.queries;

/**
 * User:Anton_Iehorov
 * Date: 12/19/2016
 * Time: 2:24 PM
 */
public class MySqlQueries {
    public static final String GET_USER = "SELECT * FROM users WHERE login = ? and password = ?";
    public static final String ADD_USERS = "INSERT INTO " +
            "users (`login`, `password`, `email`, `name`, `surname`, `phone`) " +
            "VALUES (?, ?, ?, ?, ?, ?)";
}
