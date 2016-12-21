package controller;

import bean.ErrorMessage;
import bean.RegistrFailedUserBean;
import bean.UserBean;
import constans.ApplicationConstants;
import domain.User;
import service.IUserService;
import service.UserService;

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
    private IUserService userDao;

    @Override
    public void init() throws ServletException {
        userDao = (UserService) getServletContext().getAttribute(ApplicationConstants.USERS);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO set convectors
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");


        if (userDao.exist(login)) {
            User user = new User();
            user.
                    setLogin(login).
                    setEmail(email).
                    setPassword(password).
                    setName(name).
                    setPhone(phone).
                    setSurname(surname);
            userDao.register(user);
            req.setAttribute("user", new UserBean(login));
            getServletContext().getRequestDispatcher("/success.jsp").forward(req, resp);

        } else {
            RegistrFailedUserBean registrFailedUserBean =
                    new RegistrFailedUserBean();
            registrFailedUserBean.setLogin(login).
                    setEmail(email).
                    setPassword(password).
                    setName(name).
                    setPhone(phone).
                    setSurname(surname);
            req.setAttribute("user", registrFailedUserBean);
            req.setAttribute("errorMessage", new ErrorMessage("Login '" + login + "' is already exist!"));
//            resp.sendRedirect("/registration.jsp");
            getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
        }
    }
}
