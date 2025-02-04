package school.faang.westeroslibrary;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    protected static final Map<Book, String> BOOKS_LOCATION = new HashMap<>();

    public static void main(String[] args) {
        addBook("Harry Potter", "Rowling", 2000, "first shelf");
        addBook("Little Prince", "Antuan", 3000, "second shelf");
        addBook("Sherlock Holmes", "Arthur", 4000, "third shelf");

        removeBook("Little Prince", "Antuan", 3000);

        findBook("Sherlock Holmes", "Arthur",4000);
        findBook("Sherlock Holmes2", "Arthur",4000);

        printAllBooks();
    }

    private static void addBook(String title, String author, int year, String location) {
        BOOKS_LOCATION.put(new Book(title, author, year), location);
    }

    private static void removeBook(String title, String author, int year) {
        BOOKS_LOCATION.remove(new Book(title, author, year));
    }

    private static void findBook(String title, String author, int year) {
        String location = BOOKS_LOCATION.get(new Book(title, author, year));
        if (location == null) {
            System.out.println(title + " was not found");
        } else {
            System.out.println("Book location - " + location);
        }
    }

    private static void printAllBooks() {
        BOOKS_LOCATION.forEach((book, location) -> System.out.println(book + " : " + location));
    }
}
