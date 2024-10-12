package school.faang.vesteroslibrary;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<>();

        addBook(library, new Book("A Game of Thrones", "George R. R. Martin", 1996), "Shelf 1");
        addBook(library, new Book("The Hobbit", "J.R.R. Tolkien", 1937), "Shelf 2");
        addBook(library, new Book("1984", "George Orwell", 1949), "Shelf 3");

        System.out.println("All books in the library:");
        displayBooks(library);

        System.out.println("\nSearching for '1984' by George Orwell:");
        findBook(library, new Book("1984", "George Orwell", 1949));

        System.out.println("\nRemoving 'The Hobbit':");
        removeBook(library, new Book("The Hobbit", "J.R.R. Tolkien", 1937));

        System.out.println("\nAll books in the library after removal:");
        displayBooks(library);
    }

    public static void addBook(Map<Book, String> library, Book book, String location) {
        library.put(book, location);
    }

    public static void removeBook(Map<Book, String> library, Book book) {
        library.remove(book);
    }

    public static void findBook(Map<Book, String> library, Book book) {
        String location = library.get(book);
        if (location != null) {
            System.out.println("Book found: " + book.getTitle() + " located at " + location);
        } else {
            System.out.println("Book not found.");
        }
    }

    public static void displayBooks(Map<Book, String> library) {
        library.forEach((book, location) ->
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor()
                        + ", Year: " + book.getYear() + ", Location: " + location)
        );
    }
}
