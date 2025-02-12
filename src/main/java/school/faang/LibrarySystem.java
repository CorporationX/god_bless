package school.faang;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final Map<Book, String> library = new HashMap<>();
    private static final String DEFAULT_SHELF = "1st shelf";

    public void addBook(String title, String author, int year) {
        library.put(new Book(title, author, year), DEFAULT_SHELF);
        System.out.println("Book " + title + " was added to the " + DEFAULT_SHELF);
    }

    public void addBookToShelf(String title, String author, int year, String shelf) {
        library.put(new Book(title, author, year), shelf);
        System.out.println("Book " + title + " was added to the " + shelf);
    }

    public void removeBook(String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            System.out.println(library.get(book));
        } else {
            System.out.println("No book\n");
        }
    }

    public void printAllBooks() {
        System.out.println("\nLibrary contents:");
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
