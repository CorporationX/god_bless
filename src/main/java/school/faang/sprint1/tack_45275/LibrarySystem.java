package school.faang.sprint1.tack_45275;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    public static Map<Book, String> locationByBooks = new HashMap<>();
    public static Map<String, Book> booksByLocation = new HashMap<>();

    public static boolean addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        if (!booksByLocation.containsKey(location)) {
            if (!locationByBooks.containsKey(book)) {
                locationByBooks.put(book, location);
                booksByLocation.put(location, book);
            } else {
                System.out.println("Эта книга уже стоит в другом месте");
                return false;
            }
            return true;
        }
        System.out.println("Это место уже занято книгой");
        return false;
    }

    public static boolean removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (locationByBooks.containsKey(book)) {
            booksByLocation.remove(locationByBooks.get(book));
            locationByBooks.remove(book);
            return true;
        }
        throw new BookNotFoundException("Книга не найдена");
    }

    public static String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (locationByBooks.containsKey(book)) {
            return locationByBooks.get(book);
        } else {
            throw new BookNotFoundException("Книга не найдена");
        }
    }

    public static void printAllBooks() {
        for (Map.Entry<Book, String> book : locationByBooks.entrySet()) {
            System.out.println(book);
        }
    }
}
