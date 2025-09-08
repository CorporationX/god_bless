package school.faang.BJS2_87171;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final Map<Book, String> bookLocator = new HashMap<>();

    public static void addBook(String title, String author, int year, String location) {
        Book newBook = new Book(title, author, year);
        bookLocator.put(newBook, location);
    }

    public static void removeBook(String title, String author, int year) {
        for (Map.Entry<Book, String> entry : bookLocator.entrySet()) {
            if (entry.getKey().getTitle().equals(title) && entry.getKey().getAuthor().equals(author)
                    && entry.getKey().getYear() == year) {
                bookLocator.remove(entry.getKey());
                break;
            }
        }
    }

    public static String findBook(String title, String author, int year) {
        for (Map.Entry<Book, String> entry : bookLocator.entrySet()) {
            if (entry.getKey().getTitle().equals(title) && entry.getKey().getAuthor().equals(author)
                    && entry.getKey().getYear() == year) {
                return entry.getValue();
            }
        }
        return ("К сожалению, такой книги в библиотеке нет.");
    }

    public static void printAllBooks() {
        bookLocator.forEach((book, location) -> System.out.printf(
                "Название: %s, автор: %s, год: %d, местонахождение: %s, \n", book.getTitle(),
                book.getAuthor(), book.getYear(), location));
    }
}
