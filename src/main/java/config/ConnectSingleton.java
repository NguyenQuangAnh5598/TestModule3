package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectSingleton {
    private static Connection connection;
    private static String URL = "jdbc:mysql://localhost:3306/bookmanager";
    private static String username = "root";
    private static String password = "123456789";


    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL, username, password);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Da ket noi");
        return connection;
    }
}