package ExampleWithDB.DAO.impl;

import ExampleWithDB.DAO.SubscribeDAO;
import ExampleWithDB.Models.ConnectionUtils;
import ExampleWithDB.shop.Subscribe;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubscribeDAOImpl implements SubscribeDAO {
    static String INSERT = "INSERT INTO subscribe (id_user, id_magazine, status_subscribe) VALUE(?,?,?)";
    static String READ_ALL = "SELECT * FROM subscribe";
    static String UPDATE = "UPDATE subscribe SET id_user = ?, id_magazine = ?, status_subscribe = ?";
    static String DELETE = "DELETE FROM subscribe WHERE id = ?";
    private final Connection dbConnection = ConnectionUtils.openConnection();
    private PreparedStatement preparedStatement;

    private final static Logger LOG = Logger.getLogger(SubscribeDAOImpl.class);


    public SubscribeDAOImpl() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    }

    @Override
    public void create(Subscribe subscribes) {
        try {
            preparedStatement = dbConnection.prepareStatement(INSERT);
            preparedStatement.setInt(1, subscribes.getIdUsers());
            preparedStatement.setInt(2, subscribes.getIdMagazine());
            preparedStatement.setBoolean(3, subscribes.isStatusSubscribe());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e);
        }


    }

    @Override
    public List<Subscribe> readAll() {
        List<Subscribe> subscribesList = new ArrayList<>();
        try {
            preparedStatement = dbConnection.prepareStatement(READ_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Subscribe subscribes = new Subscribe();
                subscribes.setId(resultSet.getInt("id"));
                subscribes.setIdUsers( resultSet.getInt("id_user"));
                subscribes.setIdMagazine( resultSet.getInt("id_magazine"));
                subscribes.setStatusSubscribe(resultSet.getBoolean("status_subscribe"));

                subscribesList.add(subscribes);
            }

        } catch (SQLException e) {
            LOG.error(e);
        }

        return subscribesList;
    }


    @Override
    public void update(Subscribe subscribes) {
        try {
            preparedStatement = dbConnection.prepareStatement(UPDATE);
            preparedStatement.setInt(1, subscribes.getIdUsers());
            preparedStatement.setInt(2, subscribes.getIdMagazine());
            preparedStatement.setBoolean(3, subscribes.isStatusSubscribe());

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
    public Subscribe getUserByEmail(String email) {
        return null;
    }

}
