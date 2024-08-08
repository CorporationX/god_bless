package faang.school.godbless.vesterosLibrary;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        Map<Book, String> library = new HashMap<>();
        Book book1 = new Book("Harry Potter and Philosopher's Stone", "J. K. Rowling", 1997);
        Book book2 = new Book("Dune", "Frank Herbert", 1965);
        Book book3 = new Book("Fifty Shades of Grey", "E. L. James", 2011);

        bookService.addBook(library, book1, "1A");
        bookService.addBook(library, book2, "2B");
        bookService.addBook(library, book3, "3C");

        bookService.showLibrary(library);
        System.out.println();

        bookService.removeBook(library, "Fifty Shades of Grey", "E. L. James", 2011);
        bookService.removeBook(library, "Harry Potter and Philosopher's Stone", "J. K. Rowling", 1997);
        bookService.removeBook(library, "Harry Potter and Philosopher's Stone", "J. K. Rowling", 1997);


        bookService.showLibrary(library);
        System.out.println();

        bookService.bookLocation(library, "Dune", "Frank Herbert", 1965);
        System.out.println();

        bookService.bookLocation(library, "Harry Potter and Philosopher's Stone", "J. K. Rowling", 1997);
    }
}
