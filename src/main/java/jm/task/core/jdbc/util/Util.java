package jm.task.core.jdbc.util;


import java.sql.*;

public class Util {
    private static Connection con = null;

    static {
        String url = "jdbc:mysql://localhost:3306/mydbtest";
        String user = "root";
        String pass = "root";
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return con;
    }
}
