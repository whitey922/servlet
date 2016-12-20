package controller;

import constans.ApplicationConstants;
import exception.EmptyUsersInDatabaseException;
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
 * Time: 2:32 PM
 */
@WebServlet(urlPatterns = "/auth")
public class AuthServlet extends HttpServlet {
    //TODO remove variables
    private UserService userDao;

    @Override
    public void init() throws ServletException {
        userDao = (UserService) getServletContext().getAttribute(ApplicationConstants.USERS);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //TODO add if user doesn't exist
        try {

            userDao.getUser(req.getParameter("login"), req.getParameter("password"));
            getServletContext().getRequestDispatcher("/success.jsp").forward(req, resp);
        }
        catch (EmptyUsersInDatabaseException e) {
            //TODO add error message and bean
//            req.setAttribute("user", new UserBean(login));
            getServletContext().getRequestDispatcher("/error.html").forward(req, resp);
        }
    }

}
