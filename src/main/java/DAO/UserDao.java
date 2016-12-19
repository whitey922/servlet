package DAO;

import DAO.queries.MySqlQueries;
import domain.User;
import exception.EmptyUsersInDatabaseException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    public void addUser(User user) {
        StringBuilder mysqlQueryToAddUsers = new StringBuilder();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(MySqlQueries.ADD_USERS);
            pstmt.setString(1, user.getLogin());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getName());
            pstmt.setString(5, user.getSurname());
            pstmt.setString(6, user.getPhone());
            pstmt.execute();
            System.out.println(MySqlQueries.ADD_USERS + mysqlQueryToAddUsers);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void removeUser(int id) {

    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(MySqlQueries.GET_USERS)) {
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                users.add(new User(resultSet.getString("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("name"),
                        resultSet.getString("surname")
                ));
            }
            return users;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        throw new EmptyUsersInDatabaseException("There is no users in the database!");

    }

    @Override
    public void updateUser() {

    }
}
