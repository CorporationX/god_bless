package school.faang.westeroslibrary;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final int MIN_YEAR = 1000;
    private static final int CURRENT_YEAR = java.time.Year.now().getValue();
    private static final Map<Book, String> BOOKS_LOCATION = new HashMap<>();

    public static void main(String[] args) {
        addBook("Harry Potter", "Rowling", 1998, "first shelf");
        addBook("Little Prince", "Antuan", 1999, "second shelf");
        addBook("Sherlock Holmes", "Arthur", 2000, "third shelf");

        removeBook("Little Prince", "Antuan", 2005);

        findBook("Sherlock Holmes", "Arthur", 2003);
        findBook("Sherlock Holmes2", "Arthur", 2004);

        printAllBooks();
    }

    private static boolean addBook(String title, String author, int year, String location) {
        validateInputs(title, author, year, location);

        Book bookToAdd = new Book(title, author, year);

        if (BOOKS_LOCATION.containsKey(bookToAdd)) {
            System.out.println("Book already exist");
            return false;
        }

        return true;
    }

    private static boolean removeBook(String title, String author, int year) {
        validateInputs(title, author, year);

        Book bookToRemove = new Book(title, author, year);
        if (BOOKS_LOCATION.containsKey(bookToRemove)) {
            BOOKS_LOCATION.remove(new Book(title, author, year));
            return true;
        }

        return false;
    }

    private static void findBook(String title, String author, int year) {
        validateInputs(title, author, year);

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

    private static void validateInputs(String title, String author, int year) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title is required");
        }
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author is required");
        }
        if (year < MIN_YEAR || year > CURRENT_YEAR) {
            throw new IllegalArgumentException("Invalid date year");
        }
    }

    private static void validateInputs(String title, String author, int year, String location) {
        validateInputs(title, author, year);
        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException("Location is required");
        }
    }
}
