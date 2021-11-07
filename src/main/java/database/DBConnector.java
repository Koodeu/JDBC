package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static String url = "jdbc:mysql://localhost:3306/bookstore";
    private static String user = "root";
    private static String password = "b3d3r4htxgmx";


    public static Connection getConnection() {

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("connected");
            return connection;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    return null;
    }



}





