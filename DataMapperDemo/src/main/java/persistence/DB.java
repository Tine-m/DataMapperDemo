package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/scott-tiger";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
//    private static final String URL = "jdbc:mysql://104.248.95.162:3306/test";
//    private static final String USER = "tm";
//    private static final String PASSWORD = "Knock_3*";
    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName(DRIVER); //necessary because of servlet
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
        }
        return conn;
    }

}
