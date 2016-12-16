package listener;

import constans.ApplicationConstants;
import domain.User;

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
        System.out.println("Start");
        User userFirst = new User("login", "password", "email", "123", "name", "surname");
        servletContextEvent.getServletContext().setAttribute(ApplicationConstants.USER, userFirst);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Stop");
    }
}
