package pl.polsl.mj.manager;

import java.sql.*;

import javax.xml.crypto.Data;

/**
 * DatabaseManager class, responsible for managing database.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.4
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Closing connection.
     */
    public static void closeConnection() {
        if(con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
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
     * @param con connection
     */
    public static void createConversionDataTable(Connection con) {
        try {
            Connection connection = con;
            DatabaseMetaData dbm = con.getMetaData();
            ResultSet rs = dbm.getTables(null, null, "CONVERSIONDATA", null);

            if (!rs.next()) {
                try (Statement statement = con.createStatement()) {
                    statement.executeUpdate(
                            "CREATE TABLE CONVERSIONDATA (CONVERSIONTYPE VARCHAR(20), DATAIN VARCHAR(20), DATAOUT VARCHAR(20), DATE TIMESTAMP)");
                }
            }
        } catch (Exception sqle) {
            System.err.println(sqle.getMessage());
        }
    }
    
}
