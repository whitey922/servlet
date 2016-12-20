package listener;

import DAO.ICrudDAO;
import DAO.UserDao;
import constans.ApplicationConstants;
import service.IUserService;
import service.UserService;

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
            dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/users");
            ICrudDAO iCrudDAO = new UserDao(dataSource);
            IUserService iUserService = new UserService(iCrudDAO);
            servletContextEvent.getServletContext().setAttribute(ApplicationConstants.USERS, iUserService);
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Stop system");
    }
}
