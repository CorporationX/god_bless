package gratsio_BJS2_68664;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
        System.out.println("Book added: " + book + " | to " + location);
    }
    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            System.out.println("Book removed: " + book + " | from " + library.get(book));
            library.remove(book);
        } else {
            System.out.println("This book is not in the library!");
        }
    }
    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            System.out.println("Book " + book + " is located " + library.get(book));
        } else {
            System.out.println("No books with that name, author, or year of publication have been found in our library!");
        }
    }
    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println("Book " + entry.getKey() + " is located " + entry.getValue());
        }
    }
}
