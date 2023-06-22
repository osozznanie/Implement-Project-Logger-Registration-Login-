package ExampleWithDB.Application;

import ExampleWithDB.DAO.impl.MagazineDAOImpl;
import ExampleWithDB.DAO.impl.PaymentDAOImpl;
import ExampleWithDB.DAO.impl.SubscribeDAOImpl;
import ExampleWithDB.DAO.impl.UserDAOImpl;
import ExampleWithDB.Service.impl.UserServiceImpl;

import java.sql.SQLException;
import java.text.ParseException;

public class App {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException {
        UserServiceImpl userService = new UserServiceImpl();
        userService.readAll().forEach(System.out::println);















    }
}
