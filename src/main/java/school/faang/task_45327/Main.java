package school.faang.task_45327;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> library = new HashMap<>();

    public static Map<Book, String> getMap() {
        return library;
    }

    public static void main(String[] args) {

        LibrarySystem librarySystem = new LibrarySystem();

        //some info for lib
        librarySystem.addBook("The Hobbit", "J.R.R. Tolkien", 1937, "Shelf 1");
        librarySystem.addBook("1984", "George Orwell", 1949, "Shelf 2");
        librarySystem.addBook("The Catcher in the Rye", "J.D. Salinger", 1951, "Shelf 3");

        System.out.println("--- All books in the library ---");
        librarySystem.printAllBooks();

        System.out.println("\n--- Finding a specific book ---");
        Book foundBook = librarySystem.findBook("1984", "George Orwell", 1949);
        if (foundBook != null) {
            System.out.println("Found book: " + foundBook);
        } else {
            System.out.println("Book not found.");
        }

        System.out.println("\n--- Removing a book ---");
        librarySystem.removeBook("The Hobbit", "J.R.R. Tolkien", 1937);
        System.out.println("After removal:");
        librarySystem.printAllBooks();

        System.out.println("\n--- Finding a removed book ---");
        Book removedBook = librarySystem.findBook("The Hobbit", "J.R.R. Tolkien", 1937);
        if (removedBook != null) {
            System.out.println("Found removed book: " + removedBook);
        } else {
            System.out.println("Book not found.");
        }

    }
}
