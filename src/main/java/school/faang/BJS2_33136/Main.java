package school.faang.BJS2_33136;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<Book, String> library = new HashMap<>();

    public static void addBook(Book book, String location) {
        library.put(book, location);
        System.out.println("Added: " + book + " at " + location);
    }
    public static void removeBook(Book book) {
        if (library.containsKey(book)) {
            library.remove(book);
            System.out.println("Removed: " + book);
        } else {
            System.out.println("Book not found: " + book);
        }
    }

    public static void findBook(Book book) {
        String location = library.get(book);
        if (location != null) {
            System.out.println("Found: " + book + " at " + location);
        } else {
            System.out.println("Book not found: " + book);
        }
    }

    public static void printAllBooks() {
        if (library.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Map.Entry<Book, String> entry : library.entrySet()) {
                System.out.println(entry.getKey() + " is located at " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        Book book1 = new Book("A Game of Thrones", "George R. R. Martin", 1996);
        Book book2 = new Book("A Clash of Kings", "George R. R. Martin", 1998);
        Book book3 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        Book book4 = new Book("The Fellowship of the Ring", "J.R.R. Tolkien", 1954);

        addBook(book1, "Shelf 1");
        addBook(book2, "Shelf 2");
        addBook(book3, "Shelf 3");
        addBook(book4, "Shelf 4");

        printAllBooks();

        findBook(new Book("A Game of Thrones", "George R. R. Martin", 1996));

        removeBook(new Book("The Hobbit", "J.R.R. Tolkien", 1937));

        printAllBooks();
    }
}
