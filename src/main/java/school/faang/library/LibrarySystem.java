package school.faang.library;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class LibrarySystem {
    private final Map<Book, String> bookLocations = new HashMap<>();
    private static final String REMOVE_BOOK = "We have removed book %s from the shelf %s%n";
    private static final String NO_REMOVE_BOOK = """
                    We can't delete this %s.
                    It's not in the system.
                    """;
    private static final String FIND_BOOK = """
                    The book has been found.
                    %s is on the shelf %s
                    """;
    private static final String NO_FIND_BOOK = "Unfortunately we don't have %s%n";

    public void addBook(String title, String author, int year, String location) {
        if (checkData(title, author, year) || location == null) {
            return;
        }
        bookLocations.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        if (checkData(title, author, year)) {
            return;
        }
        Book book = new Book(title, author, year);
        if (bookLocations.containsKey(book)) {

            System.out.printf(REMOVE_BOOK, book,
                    bookLocations.remove(book));
        } else {
            System.out.printf(NO_REMOVE_BOOK, book);
        }

    }

    public void findBook(String title, String author, int year) {
        if (checkData(title, author, year)) {
            return;
        }
        Book book = new Book(title, author, year);
        if (bookLocations.containsKey(book)) {
            System.out.printf(FIND_BOOK, book, bookLocations.get(book));
        } else {
            System.out.printf(NO_FIND_BOOK, book);
        }

    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> bookLocation : bookLocations.entrySet()) {
            System.out.printf("%s is on the shelf %s%n", bookLocation.getKey(), bookLocation.getValue());
        }
    }

    private boolean checkData(String title, String author, int year) {
        if (title == null || author == null) {
            System.out.println("Invalid data");
            return true;
        }
        if (year < 0 || year > LocalDate.now().getYear()) {
            System.out.println("Invalid data");
            return true;
        }
        return false;
    }

}
