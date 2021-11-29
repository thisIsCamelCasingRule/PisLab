package servlet;

import DAO.UserDao;
import DAO.UserDaoImpl;
import helpers.PostToGetRequestWrapper;
import models.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpRequest;

public class AuthHelper {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("templates/registration.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int age = Integer.getInteger(request.getParameter("age"));
        Double weight =Double.parseDouble(request.getParameter("weight"));
        Double height = Double.parseDouble(request.getParameter("height"));

        HttpSession session = request.getSession();

        UserDao<User> ud = new UserDaoImpl();
        User user = ud.getUser(username);
        if(user != null) {
            RequestDispatcher rd = request.getRequestDispatcher("templates/error.jsp");
            rd.include(request, response);
            return;
        }

        User cUser = new User(username, password, age, weight, height, 1);
        ud.insertUser(cUser);
        session.setAttribute("user", cUser);
        response.sendRedirect("/meal-list");

        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/meal-list");
        dispatcher.forward( new PostToGetRequestWrapper(request), response);

        return;

    }
}
