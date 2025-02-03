package school.faang;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> bookLocation = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        bookLocation.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String removedBook = bookLocation.remove(book);
        if (removedBook == null) {
            System.out.printf("Can't delete book %s. It isn't in library\n", book);
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (!bookLocation.containsKey(book)) {
            System.out.printf("Book %s is not in library\n", book);
        } else {
            System.out.printf("Location of book %s is %s\n", book, bookLocation.get(book));
        }

    }

    public void printAllBooks() {
        for (var entry : bookLocation.entrySet()) {
            System.out.printf("Location of book %s is %s", entry.getKey(), entry.getValue());
        }
    }
}
