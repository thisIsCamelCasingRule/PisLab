package servlet;

import DAO.UserDao;
import DAO.UserDaoImpl;
import helpers.PostToGetRequestWrapper;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserHelper {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("templates/login.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        UserDao<User> u = new UserDaoImpl();
        User user = u.getUser(username);
        if(user == null || !user.getPassword().equals(password)) {
            RequestDispatcher rd = request.getRequestDispatcher("templates/login-with-error.jsp");
            rd.include(request, response);
            return;
        }

        session.setAttribute("user", user);
        RequestDispatcher dispatcher = servletContext
                .getRequestDispatcher("/products");
        dispatcher.forward(new PostToGetRequestWrapper(request), response);

        return;
    }
}
