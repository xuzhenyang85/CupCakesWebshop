package data.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DB {

    private Connection con;
    private static DB instance;
    private static PreparedStatement stmt;
    private static String driver = "com.mysql.jdbc.Driver";
<<<<<<< HEAD
    private static String URL = "jdbc:mysql://46.101.109.188:3306/cupcakes";
    private static String id = "testuser";
    private static String pw = "test1234";
=======
    private static String URL = "jdbc:mysql://localhost:3306/cupcakes";
    private static String id = "admin";
    private static String pw = "123214322";
>>>>>>> c825205f61ca3f7fdeacfed95503a1f77d0a190f

    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL, id, pw);  // The connection will be released upon program 

        } catch (Exception e) {
            System.out.println("\n*** Remember to insert your  ID and PW in the DBConnector class! ***\n");
            System.out.println("error in DBConnector.getConnection()");
            System.out.println(e);
        }

        return con;
    }

    public void releaseConnection(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

