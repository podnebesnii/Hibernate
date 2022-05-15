package jm.task.core.jdbc.util;


import java.sql.*;

public class Util {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest", "root", "root");
    }
}
