package ExampleWithDB.Servlets;

import ExampleWithDB.DAO.impl.UserDAOImpl;
import ExampleWithDB.Service.UserService;
import ExampleWithDB.Service.impl.UserServiceImpl;
import ExampleWithDB.shop.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = UserServiceImpl.getUserServiceImpl();
    private final static Logger LOG = Logger.getLogger(RegistrationServlets.class);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");

        String password = req.getParameter("password");

        if ( login.isEmpty() || password.isEmpty()){
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }else{
            User user = userService.getUserByEmail(login);
            if (user != null && user.getPassword().equals(password)) {
                req.setAttribute("login", login);
                req.getRequestDispatcher("cabinet.jsp").forward(req, resp);
            } else {
                req.setAttribute("errorMessage", "Incorrect login or password");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        }
    }
}
