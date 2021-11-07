import book.BookDAO;

public class Main {
    public static void main(String[] args) {

        BookDAO bookDAO = new BookDAO();
        bookDAO.findBooksTitles();

    }

}
