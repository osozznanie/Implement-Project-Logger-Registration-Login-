package ExampleWithDB.Service.impl;

import ExampleWithDB.DAO.SubscribeDAO;
import ExampleWithDB.DAO.impl.SubscribeDAOImpl;
import ExampleWithDB.Service.SubscribeService;
import ExampleWithDB.shop.Subscribe;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class SubscribeServiceImpl implements SubscribeService {
    private SubscribeDAO subscribeDAO;
    private final static Logger LOG = Logger.getLogger(SubscribeServiceImpl.class);
    private static SubscribeService subscribeServiceImpl;

    public static SubscribeService getSubscribeServiceImpl() {
        if (subscribeServiceImpl == null) {
            return new SubscribeServiceImpl();
        }
        return subscribeServiceImpl;
    }

    public SubscribeServiceImpl(){
        try {
            subscribeDAO = new SubscribeDAOImpl();
        } catch (SQLException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            LOG.error(e);
        }
    }

    @Override
    public void create(Subscribe subscribe) {
        try {
            subscribeDAO.create(subscribe);
        } catch (SQLException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            LOG.error(e);
        }
    }

    @Override
    public List<Subscribe> readAll() {
        return subscribeDAO.readAll();
    }

    @Override
    public void update(Subscribe subscribe) {
        subscribeDAO.update(subscribe);
    }

    @Override
    public void deleteById(int id) {
        subscribeDAO.deleteById(id);
    }

    @Override
    public Subscribe getUserByEmail(String email) {
        return subscribeDAO.getUserByEmail(email);
    }
}
