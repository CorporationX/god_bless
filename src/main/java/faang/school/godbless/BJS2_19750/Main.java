package faang.school.godbless.BJS2_19750;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        addBook(new Book("A Game of Thrones", "George R. R. Martin", 1996), "Shelf 1");
        addBook(new Book("A Clash of Kings", "George R. R. Martin", 1998), "Shelf 2");
        addBook(new Book("A Storm of Swords", "George R. R. Martin", 2000), "Shelf 3");

        printAllBooks();
        System.out.println();

        printBookLocation(new Book("A Game of Thrones", "George R. R. Martin", 1996));
        System.out.println();

        removeBook(new Book("A Clash of Kings", "George R. R. Martin", 1998));
        printAllBooks();
        System.out.println();

        addBook(new Book("A Feast for Crows", "George R. R. Martin", 2005), "Shelf 4");
        printAllBooks();
    }

    public static void addBook(Book book, String location) {
        library.put(book, location);
        System.out.println("Added book: " + book + " to " + location);
    }

    public static void removeBook(Book book) {
        if (library.remove(book) != null) {
            System.out.println("Removed book: " + book);
        } else {
            System.out.println("Book " + book + " not found for removal.");
        }
    }

    public static void printBookLocation(Book book) {
        String location = library.get(book);
        if (location != null) {
            System.out.println("Location of " + book + ": " + location);
        } else {
            System.out.println("Book " + book + " not found in the library.");
        }
    }

    public static void printAllBooks() {
        if (library.isEmpty()) {
            System.out.println("No books found in the library.");
        } else {
            library.forEach((book, location) -> System.out.println(book + " is located at " + location));
        }
    }
}
