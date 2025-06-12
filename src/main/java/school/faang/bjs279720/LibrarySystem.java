package school.faang.bjs279720;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> library;

    public LibrarySystem() {
        library = new HashMap<>();
    }

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
        System.out.println("Book added!");
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String removed = library.remove(book);

        if (removed != null) {
            System.out.println("Book removed!");
        } else {
            System.out.println("Book not found!");
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = library.get(book);

        if (location != null) {
            System.out.println("Book found: " + location + "!");
        } else {
            System.out.println("Book not found!");
        }
    }

    public void printAllBooks() {
        if (library.isEmpty()) {
            System.out.println("Library is empty!");
            return;
        }
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            Book book = entry.getKey();
            String location = entry.getValue();
            System.out.println(book.getTitle() + " " + book.getAuthor() + " " + book.getYear() + " " + location);
        }
    }
}
