package publisher;

import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PublisherDAO {

    public PublisherDTO findPublisher(String publisherName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        String sql = "select id, name, description, email, dialing_code, phone_number from publishers " +
                "where name=?";


        try {
            connection = databaseConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, publisherName);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String email = resultSet.getString("email");
                String dialingCode = resultSet.getString("dialing_code");
                String phoneNumber = resultSet.getString("phone_number");
                PublisherDTO publisherDTO = PublisherDTO
                        .builder()
                        .id(id)
                        .name(name)
                        .description(description)
                        .email(email)
                        .dialingCode(dialingCode)
                        .phoneNumber(phoneNumber)
                        .build();

                return publisherDTO;

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseConnection.freeResources(connection, preparedStatement, resultSet);
        }

        return null;
    }

}
