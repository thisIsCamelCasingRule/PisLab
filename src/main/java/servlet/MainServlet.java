package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api")
public class MainServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // System.out.println("Entered doGet");
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        processRequest(request, response);
    }



    private void processRequest(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        System.out.println("request.getServletPath() = " + request.getServletPath());
        System.out.println("Token in Servlet  = " + response.getHeader("Authorization"));


        switch (request.getServletPath()) {
            case "/login":
                UserHelper userHelper = new UserHelper();
                if (request.getMethod().equals("POST")) {
                    userHelper.doPost(request, response, getServletContext());
                }
                if(request.getMethod().equals("GET")) {
                    userHelper.doGet(request, response);
                }
                break;

            case "/registration":
                AuthHelper authHelper = new AuthHelper();
                if (request.getMethod().equals("POST")){
                    authHelper.doPost(request, response, getServletContext());
                }
                if(request.getMethod().equals("GET")) {
                    authHelper.doGet(request, response);
                }
                break;

            case "/meal":
                MealHelper productsHelper = new MealHelper();

                if (request.getMethod().equals("POST")) {
                    productsHelper.doPost(request, response, getServletContext());
                }
                if(request.getMethod().equals("GET")) {
                    productsHelper.doGet(request, response, getServletContext());
                }
                break;

        }
    }

}
