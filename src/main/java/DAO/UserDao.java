package DAO;

import DAO.queries.MySqlQueries;
import domain.User;
import exception.EmptyUsersInDatabaseException;
import service.exception.UserDidntAddedException;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Objects;

/**
 * User:Anton_Iehorov
 * Date: 12/16/2016
 * Time: 3:59 PM
 */
public class UserDao implements ICrudDAO {
    private DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = Objects.requireNonNull(dataSource);
    }

    @Override
    public User addUser(User user) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(MySqlQueries.ADD_USERS, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getLogin());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getName());
            pstmt.setString(5, user.getSurname());
            pstmt.setString(6, user.getPhone());
            ResultSet resultSet = pstmt.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }

            pstmt.executeUpdate();
            return user;
        } catch (SQLException e) {
           throw new UserDidntAddedException("Added failed");
        }
    }

    @Override
    public void removeUser(int id) {

    }

    @Override
    public User getUser(String login, String password) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(MySqlQueries.GET_USER)) {
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            ResultSet resultSet = pstmt.executeQuery();
            //TODO check if DB return more than 1 user
            if (resultSet.next()) {
                User user = new User();
                user.
                        setId(resultSet.getInt("id")).
                        setLogin(resultSet.getString("login")).
                        setEmail(resultSet.getString("email")).
                        setPassword(resultSet.getString("password")).
                        setName(resultSet.getString("name")).
                        setPhone(resultSet.getString("phone")).
                        setSurname(resultSet.getString("surname"));

                return user;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        throw new EmptyUsersInDatabaseException("There is no users in the database!");

    }

    @Override
    public void updateUser() {

    }
}
