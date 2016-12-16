package controller;

import constans.ApplicationConstants;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User:Anton_Iehorov
 * Date: 12/16/2016
 * Time: 2:32 PM
 */
@WebServlet(urlPatterns = "/auth")
public class AuthServlet extends HttpServlet {
    private String login;
    private String password;
    private User user;

    @Override
    public void init() throws ServletException {
        user = (User) getServletContext().getAttribute(ApplicationConstants.USER);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.login = req.getParameter("login");
        this.password = req.getParameter("password");

        if (isAuth(user))
            getServletContext().getRequestDispatcher("/success.html").forward(req, resp);
        else
            getServletContext().getRequestDispatcher("/error.html").forward(req, resp);
    }

    private boolean isAuth(User user) {
        return user.getLogin().equals(login) && user.getPassword().equals(password);
    }
}
