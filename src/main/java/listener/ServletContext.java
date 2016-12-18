package listener;

import DAO.UserDao;
import constans.ApplicationConstants;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * User:Anton_Iehorov
 * Date: 12/16/2016
 * Time: 12:54 PM
 */
public class ServletContext implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Start system");
        UserDao userDao = new UserDao();
        servletContextEvent.getServletContext().setAttribute(ApplicationConstants.USERS, userDao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Stop system");
    }
}
