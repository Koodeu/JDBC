package categories;


import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryDAO {

    public int insert(String name, String code) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        String sql = "insert into categories(code, name) values (?, ?);";

        try {
            connection = databaseConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, name);
            return preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {

            databaseConnection.freeResources(connection, preparedStatement, null);
        }
        return 0;
    }

    public int deleteByCode(String code){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        String sql = "delete from categories where code=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, code);
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseConnection.freeResources(connection, preparedStatement, null);
        }
        return 0;
    }



}
