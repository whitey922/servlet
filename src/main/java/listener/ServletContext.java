package listener;

import DAO.UserDao;
import constans.ApplicationConstants;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

/**
 * User:Anton_Iehorov
 * Date: 12/16/2016
 * Time: 12:54 PM
 */
public class ServletContext implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Start system");
        DataSource dataSource = null;
        try {
            dataSource = (DataSource)new InitialContext().lookup("java:comp/env/jdbc/users");
            servletContextEvent.getServletContext().setAttribute(ApplicationConstants.USERS,
                    new UserDao((javax.sql.DataSource) dataSource));
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Stop system");
    }
}
