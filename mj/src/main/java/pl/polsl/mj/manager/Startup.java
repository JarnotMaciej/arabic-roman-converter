package pl.polsl.mj.manager;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

/**
 * Startup class, responsible for initializing database and performing cleanup.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.4
 */
public class Startup implements ServletContextListener {

    /**
     * Method called when context is initialized.
     *
     * @param sce servlet context event
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        // getting params from web.xml
        String dburl = context.getInitParameter("dburl");
        String dbuser = context.getInitParameter("dbuser");
        String dbpassword = context.getInitParameter("dbpassword");
        DatabaseConnector.createConnection(dburl, dbuser, dbpassword);
        System.out.println("Database initialized!");
        DatabaseConnector.createConversionDataTable(DatabaseConnector.getConnection());
        System.out.println("Database table is ready!");
    }

    /**
     * Method called when context is destroyed.
     *
     * @param sce servlet context event
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DatabaseConnector.closeConnection();
        
        System.out.println("Database cleaning executed!");
    }
}
