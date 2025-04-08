package school.faang.libraryofwesteros;

import java.util.HashMap;
import java.util.Map;

/**
 * Related to JIRA ticket: BJS2-68651
 */
public class LibrarySystem {
    private final HashMap<Book, String> bookLocation = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        bookLocation.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        bookLocation.remove(new Book(title, author, year));
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (bookLocation.containsKey(book)) {
            System.out.printf("Book %s located: %s\n", book, bookLocation.get(book));
        } else {
            System.out.println("Book is not in the Library!");
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : bookLocation.entrySet()) {
            System.out.printf("Book %s located %s\n", entry.getKey(), entry.getValue());
        }
    }
}
