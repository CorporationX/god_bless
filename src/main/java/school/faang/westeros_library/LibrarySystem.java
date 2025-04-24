package school.faang.westeros_library;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class LibrarySystem {
    private final Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        library.put(new Book(title, author, year), location);
        System.out.printf("Book has been to this location: %s\n", location);
    }

    public void removeBook(String title, String author, int year) {
        if (library.remove(new Book(title, author, year)) == null) {
            System.out.println("There's no such book.");
        } else {
            System.out.println("Book removed.");
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (!library.containsKey(book)) {
            throw new NoSuchElementException("There's no such book.");
        }
        System.out.println(book);
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.printf("%s - %s\n", entry.getKey(), entry.getValue());
        }
    }
}
