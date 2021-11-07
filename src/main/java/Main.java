import book.BookDAO;
import database.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        BookDAO bookDAO = new BookDAO();
        bookDAO.findBooksTitles();

    }

}
