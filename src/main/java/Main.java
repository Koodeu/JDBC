import book.BookDAO;
import book.BookDTO;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        BookDAO bookDAO = new BookDAO();
        List<BookDTO> titles = bookDAO.findBooks();


        titles.forEach(System.out::println);

    }

}
