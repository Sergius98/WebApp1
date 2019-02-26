package ua.training.servlet;

import ua.training.controller.Controller;
import ua.training.model.Model;
import ua.training.model.View;
import java.io.IOException;

public class Home extends javax.servlet.http.HttpServlet {
    private static Controller controller = new Controller(new Model(), new View());
    private static String HOME = "view/index.jsp";
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //request.setAttribute("MESSAGE", "value");
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        request.setAttribute("MESSAGE", controller.processUser(name, login));
        request.setAttribute("name", name);
        request.setAttribute("login", login);
        request.getRequestDispatcher(HOME).forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("MESSAGE", "Input a name and an unique login");
        request.getRequestDispatcher(HOME).forward(request, response);
    }
}
