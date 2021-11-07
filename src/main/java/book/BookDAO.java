package book;

import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public List<String> findBooksTitles() {

        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        Connection connection = databaseConnection.getConnection();
        String sqlQuery = "select * from books;";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<String> titles = new ArrayList<String>();

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                titles.add(title);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseConnection.freeResources(connection, preparedStatement, resultSet);


        }

        return titles;
    }

    public List<BookDTO> findBooks() {


        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        Connection connection = databaseConnection.getConnection();

        StringBuilder sqlBuilder = new StringBuilder()
                .append("select b.id as bookId, b.title as bookTitle, b.pages_number as pagesNumber, ")
                .append("c.name as categoryName, p.name as publisherName, ")
                .append("concat(a.first_name, a.last_name) as authorFullName ")
                .append("from books b join categories c on b.category_id = c.id ")
                .append("join publishers p on p.id = b.publisher_id ")
                .append("join authors_books ab on ab.book_id=b.id ")
                .append("join authors a on a.id=ab.author_id;");
        String sql = sqlBuilder.toString();

        String sqlQuery = "select * from books;";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<BookDTO> books = new ArrayList<BookDTO>();

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("bookId");
                String title = resultSet.getString("title");
                int pagesNumber = resultSet.getInt("pagesNumber");
                String categoryName = resultSet.getString("categoryName");
                String publishersName = resultSet.getString("publishersName");
                String author = resultSet.getString("authorFullName");
                BookDTO book = BookDTO.builder()
                        .id(id)
                        .title(title)
                        .pagesNumber(pagesNumber)
                        .categoryName(categoryName)
                        .publisherName(publishersName)
                        .author(author)
                        .build();
                books.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseConnection.freeResources(connection, preparedStatement, resultSet);


        }

        return books;
    }

}



