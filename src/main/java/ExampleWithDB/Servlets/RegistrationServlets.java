package ExampleWithDB.Servlets;

import ExampleWithDB.DAO.impl.UserDAOImpl;
import ExampleWithDB.Service.UserService;
import ExampleWithDB.Service.impl.UserServiceImpl;
import ExampleWithDB.shop.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import org.apache.log4j.Logger;


@WebServlet("/register")
public class RegistrationServlets extends HttpServlet {
    private final UserService userService = UserServiceImpl.getUserServiceImpl();
    private final static Logger LOG = Logger.getLogger(RegistrationServlets.class);



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String level = req.getParameter("userType");

        User user = new User(firstName, lastName, email, password, level);

        if (firstName.isEmpty()  || lastName.isEmpty() || email.isEmpty() || password.isEmpty()){
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }else{
            if(userService.getUserByEmail(email).getEmail().equals(user.getEmail())){
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            }else{
                try {
                    userService.create(user);
                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                    LOG.error(e);
                }
                System.out.println(user);
                req.setAttribute("email", email);
                req.getRequestDispatcher("cabinet.jsp").forward(req, resp);
            }
        }
    }
}
