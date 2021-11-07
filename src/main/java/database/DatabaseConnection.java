package database;

import java.sql.*;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private String url = "jdbc:mysql://localhost:3306/bookstore";
    private String user = "root";
    private String password = "b3d3r4htxgmx";

    private DatabaseConnection() {

    }

    synchronized public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance
    }

    public Connection getConnection() {

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("connected");
            return connection;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    public void freeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (preparedStatement != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}





