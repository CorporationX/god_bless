package school.faang.westeroslibrary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The {@code Main} class contains the main entry point for the Westeros Library application
 * and includes test methods for verifying the functionality of the {@link Book} and
 * {@link LibrarySystem} classes.
 */
public class Main {

    /**
     * The main method that serves as the entry point of the application.
     * It calls the test methods for the {@link Book} and {@link LibrarySystem} classes.
     *
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        testBook();
        testLibrarySystem();
    }

    /**
     * Tests the functionality of the {@link Book} class, specifically its
     * {@code equals()} and {@code hashCode()} methods. It creates several
     * {@code Book} instances with different properties and uses assertions
     * (via {@code System.out.println()}) to verify the expected behavior
     * in equality comparisons and when used as keys in a {@link HashMap}
     * and elements in a {@link HashSet}.
     */
    public static void testBook() {
        System.out.println("--- Testing Book Class (equals and hashCode) ---");

        Book book1 = new Book("A Game of Thrones", "George R.R. Martin", 1996);
        Book book2 = new Book("A Game of Thrones", "George R.R. Martin", 1996);
        Book book3 = new Book("A Clash of Kings", "George R.R. Martin", 1999);
        Book book4 = new Book("A Game of Thrones", "Someone Else", 1996);
        Book book5 = new Book("A Game of Thrones", "George R.R. Martin", 1997);

        // Test Case 1: Equality of two identical books
        System.out.println("\nTest Case 1: Identical Books");
        System.out.println("book1.equals(book2): " + book1.equals(book2));
        System.out.println("book1.hashCode() == book2.hashCode(): " + (book1.hashCode() == book2.hashCode()));

        // Test Case 2: Inequality due to different title
        System.out.println("\nTest Case 2: Different Title");
        System.out.println("book1.equals(book3): " + book1.equals(book3));
        System.out.println("book1.hashCode() == book3.hashCode(): " + (book1.hashCode() == book3.hashCode()));

        // Test Case 3: Inequality due to different author
        System.out.println("\nTest Case 3: Different Author");
        System.out.println("book1.equals(book4): " + book1.equals(book4));
        System.out.println("book1.hashCode() == book4.hashCode(): " + (book1.hashCode() == book4.hashCode()));

        // Test Case 4: Inequality due to different year
        System.out.println("\nTest Case 4: Different Year");
        System.out.println("book1.equals(book5): " + book1.equals(book5));
        System.out.println("book1.hashCode() == book5.hashCode(): " + (book1.hashCode() == book5.hashCode()));

        // Test Case 5: Using Book objects as keys in HashMap (equality and hashCode in action)
        System.out.println("\nTest Case 5: Books as HashMap Keys");
        Map<Book, String> bookLocations = new HashMap<>();
        bookLocations.put(book1, "Shelf A1");
        bookLocations.put(book2, "Shelf B2"); // Should overwrite book1 due to equals and hashCode
        System.out.println("Size of bookLocations (should be 1): " + bookLocations.size());
        System.out.println("Location of book1 (should be Shelf B2): " + bookLocations.get(book1));
        System.out.println("Location of book2 (should be Shelf B2): " + bookLocations.get(book2));
        System.out.println("Location of book3 (should be null): " + bookLocations.get(book3));

        // Test Case 6: Using Book objects in HashSet (equality and hashCode in action)
        System.out.println("\nTest Case 6: Books in HashSet");
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2); // Should not add as it's equal to book1
        bookSet.add(book3);
        System.out.println("Size of bookSet (should be 2): " + bookSet.size());
        System.out.println("Contains book1: " + bookSet.contains(book1));
        System.out.println("Contains book2: " + bookSet.contains(book2));
        System.out.println("Contains book3: " + bookSet.contains(book3));
    }

    /**
     * Tests the functionality of the {@link LibrarySystem} class, including adding books,
     * finding books by their properties, removing books, and printing all books in the library.
     * It creates a {@code LibrarySystem} instance and performs several operations,
     * printing the results to the console to verify the expected behavior.
     */
    public static void testLibrarySystem() {
        System.out.println("\n--- Testing LibrarySystem Class ---");
        LibrarySystem library = new LibrarySystem();

        library.addBook("A Game of Thrones", "George R.R. Martin", 1996, "Shelf A1");
        library.addBook("A Clash of Kings", "George R.R. Martin", 1999, "Shelf B2");

        System.out.println("\nTest Case 7 (Library): Finding existing book");
        System.out.println("Location of 'A Game of Thrones': "
                + library.findBook("A Game of Thrones", "George R.R. Martin", 1996));

        System.out.println("\nTest Case 8 (Library): Adding duplicate (overwrites location)");
        library.addBook("A Game of Thrones", "George R.R. Martin", 1996, "Shelf C3");
        System.out.println("Location of 'A Game of Thrones' after adding again: "
                + library.findBook("A Game of Thrones", "George R.R. Martin", 1996));

        System.out.println("\nTest Case 9 (Library): Removing a book");
        library.removeBook("A Clash of Kings", "George R.R. Martin", 1999);
        System.out.println("Location of 'A Clash of Kings' after removal: "
                + library.findBook("A Clash of Kings", "George R.R. Martin", 1999));

        System.out.println("\nTest Case 10 (Library): Printing all books");
        System.out.println("All Books in Library:\n" + library.printAllBooks());
    }
}