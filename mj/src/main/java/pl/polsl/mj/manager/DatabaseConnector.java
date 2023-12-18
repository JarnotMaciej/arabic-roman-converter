package pl.polsl.mj.manager;

import java.sql.*;

/**
 * DatabaseManager class, responsible for managing database.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.5
 */
public class DatabaseConnector {
    /**
     * Connection.
     */
    private static Connection con;

    /**
     * Creates connection.
     * 
     * @param dburl database url
     * @param dbuser database user
     * @param dbpassword database password
     */
    public static void createConnection(String dburl, String dbuser, String dbpassword) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection(dburl, dbuser, dbpassword);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Closing connection.
     */
    public static void closeConnection() {
        if(con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    
    /**
     * Returns the database connection.
     *
     * @return the database connection
     */
    public static Connection getConnection() {
        return con;
    }

    /**
     * Method responsible for creating conversion data table.
     *
     */
    public static void createConversionDataTable() {
        try {
            DatabaseMetaData dbm = con.getMetaData();
            ResultSet rs = dbm.getTables(null, null, "CONVERSIONDATA", null);

            if (!rs.next()) {
                try (Statement statement = con.createStatement()) {
                    statement.executeUpdate(
                            "CREATE TABLE CONVERSIONDATA (CONVERSIONTYPE VARCHAR(20), DATAIN VARCHAR(20), DATAOUT VARCHAR(20), DATE TIMESTAMP)");
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Method responsible for clearing conversion data table.
     */
    public static void clearConversionDataTable() {
        try {
            Connection con = getConnection();

            try (Statement statement = con.createStatement()) {
                statement.executeUpdate("DELETE FROM ConversionData");
            } catch (Exception sqle) {
                System.err.println(sqle.getMessage());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
