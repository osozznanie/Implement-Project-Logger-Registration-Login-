package ExampleWithDB.DAO.impl;

import ExampleWithDB.DAO.UserDAO;
import ExampleWithDB.Models.ConnectionUtils;
import ExampleWithDB.shop.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    static String INSERT = "INSERT INTO user (first_name, last_name, email, password, level) VALUE(?,?,?,?,?)";
    static String READ_ALL = "SELECT * FROM user";
    static String UPDATE = "UPDATE user SET first_name = ?, last_name = ?, email = ?, password = ?, level = ?";
    static String DELETE = "DELETE FROM user WHERE id = ?";
    private final Connection dbConnection = ConnectionUtils.openConnection();
    private PreparedStatement preparedStatement;

    private final static Logger LOG = Logger.getLogger(UserDAOImpl.class);


    public UserDAOImpl() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    }

    @Override
    public void create(User users) {
        try {
            preparedStatement = dbConnection.prepareStatement(INSERT);
            preparedStatement.setString(1, users.getFirstName());
            preparedStatement.setString(2, users.getLastName());
            preparedStatement.setString(3, users.getEmail());
            preparedStatement.setString(4, users.getPassword());
            preparedStatement.setString(5, users.getLevel());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e);
        }


    }

    @Override
    public List<User> readAll() {
        List<User> usersList = new ArrayList<>();
        try {
            preparedStatement = dbConnection.prepareStatement(READ_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                User users = new User();
                users.setId(resultSet.getInt("id"));
                users.setFirstName(resultSet.getString("first_name"));
                users.setLastName(resultSet.getString("last_name"));
                users.setEmail(resultSet.getString("email"));
                users.setPassword(resultSet.getString("password"));
                users.setLevel(resultSet.getString("level"));

                usersList.add(users);
            }

        } catch (SQLException e) {
            LOG.error(e);
        }

        return usersList;
    }


    @Override
    public void update(User users) {
        try {
            preparedStatement = dbConnection.prepareStatement(UPDATE);
            preparedStatement.setString(1, users.getFirstName());
            preparedStatement.setString(2, users.getLastName());
            preparedStatement.setString(3, users.getEmail());
            preparedStatement.setString(4, users.getPassword());
            preparedStatement.setString(5, users.getLevel());



            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e);
        }



    }

    @Override
    public void deleteById(int id) {
        try {
            preparedStatement = dbConnection.prepareStatement(DELETE);
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e);
        }

    }
    @Override
    public User getUserByEmail(String email) {
        String query = "SELECT * FROM user WHERE email = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setLevel(resultSet.getString("level"));
                return user;
            }
        } catch (SQLException e) {
            LOG.error(e);
        }
        return null;
    }
}
