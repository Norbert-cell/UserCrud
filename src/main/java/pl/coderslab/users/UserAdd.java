package pl.coderslab.users;

import pl.coderslab.User;
import pl.coderslab.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/add")
public class UserAdd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUserName(req.getParameter("userName"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        UserDao userDao = new UserDao();
        userDao.createUser(user);
        resp.sendRedirect(req.getContextPath() + "/user/list");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/user/addUser.jsp")
                .forward(request, response);
    }
}
