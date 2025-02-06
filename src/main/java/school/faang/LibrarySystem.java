package school.faang;

import java.util.HashMap;
import java.util.Map;


public class LibrarySystem {
    private static final HashMap<Book, String> bookLocation = new HashMap<>();

    public static void main(String[] args) {
        Book book1 = new Book("LofR", "Tolkien", 1954);
        Book book2 = new Book("GoT", "Martin", 1996);
        Book book3 = new Book("Life", "Me", 2025);

        addBook(book1, "1");
        addBook(book2, "332");
        addBook(book3, "999");

        removeBook("GoT", "Martin", 1996);

        findBook("Life", "Me", 2025);

        printAllBooks();
    }

    private static void addBook(Book book, String shelf) {
        bookLocation.put(book, shelf);
    }

    private static void removeBook(String title, String author, int year) {
        bookLocation.remove(new Book(title, author, year));
    }

    private static void printAllBooks() {
        for (Map.Entry<Book, String> entry : bookLocation.entrySet()) {
            System.out.println("Book: " + entry.getKey() + " - Shelf: " + entry.getValue());
        }
    }

    private static void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = bookLocation.get(book);
        if (location != null) {
            System.out.println("Found book: " + book + " at shelf: " + location);
        } else {
            System.out.println("Book: " + book + " not found" );
        }
    }
}
