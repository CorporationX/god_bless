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

        librarySystem.addBook("The Hobbit", "J.R.R. Tolkien", 1937, "Shelf 1");
        librarySystem.addBook("1984", "George Orwell", 1949, "Shelf 2");
        librarySystem.addBook("The Catcher in the Rye", "J.D. Salinger", 1951, "Shelf 3");

        System.out.println("--- All books in the library ---");
        librarySystem.printAllBooks();

        System.out.println("\n--- Finding a specific book (1984)---");
        String location = librarySystem.findBook("1984", "George Orwell", 1949);
        if (location != null) {
            System.out.println("Found book located at: " + location);
        } else {
            System.out.println("Book not found.");
        }

        System.out.println("\n--- Removing a book ---");
        boolean removed = librarySystem.removeBook("The Hobbit", "J.R.R. Tolkien", 1937);
        if (removed) {
            System.out.println("The book was successfully removed.");
        } else {
            System.out.println("The book could not be found for removal.");
        }
        System.out.println("After removal:");
        librarySystem.printAllBooks();

        System.out.println("\n--- Finding a removed book ---");
        location = librarySystem.findBook("The Hobbit", "J.R.R. Tolkien", 1937);
        if (location != null) {
            System.out.println("Found removed book located at: " + location);
        } else {
            System.out.println("Book not found.");
        }
    }
}
