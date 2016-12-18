package controller;

import DAO.UserDao;
import bean.ErrorMessage;
import bean.RegistrFailedUserBean;
import bean.UserBean;
import constans.ApplicationConstants;
import domain.User;
import validator.UserValidationRegistration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User:Anton_Iehorov
 * Date: 12/16/2016
 * Time: 2:33 PM
 */
@WebServlet(urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    private UserDao userDao;
    private String login;
    private String password;
    private String email;
    private String phone;
    private String name;
    private String surname;

    @Override
    public void init() throws ServletException {
        userDao = (UserDao) getServletContext().getAttribute(ApplicationConstants.USERS);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.login = req.getParameter("login");
        this.password = req.getParameter("password");
        this.email = req.getParameter("email");
        this.phone = req.getParameter("phone");
        this.name = req.getParameter("name");
        this.surname = req.getParameter("surname");

        if (UserValidationRegistration.isLoginNotExist(userDao, login)) {
            userDao.addUser(new User(login, password, email, phone, name, surname));
            req.setAttribute("user", new UserBean(login));
            getServletContext().getRequestDispatcher("/success.jsp").forward(req, resp);
        } else {
            RegistrFailedUserBean registrFailedUserBean =
                    new RegistrFailedUserBean(login, password, email, phone, name, surname);
            req.setAttribute("user", registrFailedUserBean);
            req.setAttribute("errorMessage", new ErrorMessage("Login '" + login + "' is already exist!"));
            getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
        }
    }
}
