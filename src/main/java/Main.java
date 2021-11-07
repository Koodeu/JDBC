import book.BookDAO;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        BookDAO bookDAO = new BookDAO();
        List<String> titles = bookDAO.findBooksTitles();


        titles.forEach(System.out::println);

    }

}
