import book.BookDAO;
import book.BookDTO;
import publisher.PublisherDAO;
import publisher.PublisherDTO;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        BookDAO bookDAO = new BookDAO();
//        List<BookDTO> titles = bookDAO.findBooks();
//        titles.forEach(System.out::println);

        PublisherDAO publisherDAO = new PublisherDAO();
        PublisherDTO publisherDTO = publisherDAO.findPublisher("Wydawnictwo Zgierz");
        System.out.println(publisherDTO);
    }

}
