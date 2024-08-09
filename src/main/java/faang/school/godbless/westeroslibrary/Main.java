package faang.school.godbless.westeroslibrary;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        library.put(new Book("A Game of Thrones", "George R. R. Martin", 1996), "Shelf 1");
        library.put(new Book("A Clash of Kings", "George R. R. Martin", 1998), "Shelf 1");
        library.put(new Book("A Storm of Swords", "George R. R. Martin", 2000), "Shelf 2");

        System.out.println("Adding 'The Hobbit' by J.R.R. Tolkien...");
        addBook(new Book("The Hobbit", "J.R.R. Tolkien", 1937), "Shelf 3");

        System.out.println("\nAll Books and their Locations:");
        printAllBooks();

        System.out.println("\nFinding the location of 'A Game of Thrones':");
        findBook("A Game of Thrones", "George R. R. Martin", 1996);

        System.out.println("\nRemoving Book 'The Hobbit':");
        removeBook("The Hobbit", "J.R.R. Tolkien", 1937);

        System.out.println("\nAll Books after removing 'The Hobbit':");
        printAllBooks();
    }

    public static void addBook(Book book, String location) {
        library.put(book, location);
    }

    public static void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        library.remove(book);
    }

    public static String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = library.get(book);
        if (location != null) {
            System.out.println("Location: " + location);
        } else {
            System.out.println("Book not found.");
        }
        return location;
    }

    public static void printAllBooks() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
