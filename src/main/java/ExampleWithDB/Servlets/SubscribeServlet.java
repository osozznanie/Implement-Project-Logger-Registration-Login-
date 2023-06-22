package ExampleWithDB.Servlets;

import javax.servlet.http.HttpServlet;

public class SubscribeServlet extends HttpServlet {

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("here");
//        req.getRequestDispatcher("cabinet.jsp").forward(req, resp);
//
//        resp.getWriter().append("Served at: ").append(req.getContextPath());
//        req.getRequestDispatcher("register.jsp").forward(req, resp);
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        try {
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        String firstName = req.getParameter("firstName");
//        String lastName = req.getParameter("lastName");
//        String email = req.getParameter("email");
//        String password = req.getParameter("password");
//
//        Users user = new Users(firstName, lastName, email, password);
//
//        if (firstName.isEmpty()  || lastName.isEmpty() || email.isEmpty() || password.isEmpty()){
//            req.getRequestDispatcher("register.jsp").forward(req, resp);
//        }else{
//            System.out.println(user);
//            req.setAttribute("firstName", firstName);
//            req.getRequestDispatcher("cabinet.jsp").forward(req, resp);
//        }
//    }
}
