package controller;

import DAO.UserDao;
import bean.UserBean;
import constans.ApplicationConstants;
import validator.UserValidationAuth;

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
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = (UserDao) getServletContext().getAttribute(ApplicationConstants.USERS);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.login = req.getParameter("login");
        this.password = req.getParameter("password");

        if (UserValidationAuth.isUserAuth(userDao, login, password)) {
            req.setAttribute("user", new UserBean(login));
            getServletContext().getRequestDispatcher("/success.jsp").forward(req, resp);
        } else
            getServletContext().getRequestDispatcher("/error.html").forward(req, resp);
    }
}
