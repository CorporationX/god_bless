package school.faang.bjs2_87171;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final Map<Book, String> bookLocator = new HashMap<>();

    public static void addBook(String title, String author, int year, String location) {
        Book newBook = new Book(title, author, year);
        bookLocator.put(newBook, location);
    }

    public static void removeBook(String title, String author, int year) throws Exception {
        if (title == null || author == null) {
            throw new Exception("Поле название или автор равно null.");
        }
        Book book = new Book(title, author, year);
        bookLocator.remove(book);
    }

    public static String findBook(String title, String author, int year) throws Exception {
        if (title == null || author == null) {
            throw new Exception("Поле название или автор равно null.");
        }
        Book book = new Book(title, author, year);
        String location = bookLocator.get(book);
        if (location == null) {
            return ("К сожалению, такой книги в библиотеке нет.");
        }
        return location;
    }

    public static void printAllBooks() {
        bookLocator.forEach((book, location) -> System.out.printf(
                "Название: %s, автор: %s, год: %d, местонахождение: %s, \n", book.getTitle(),
                book.getAuthor(), book.getYear(), location));
    }
}
