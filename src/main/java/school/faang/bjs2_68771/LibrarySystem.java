package school.faang.bjs2_68771;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class LibrarySystem {
    public static final String BOOK_NOT_FOUND = "Книга не найдена: %s";
    public static final String BOOK_INFO = "Книга: %s; Расположение: %s\n";

    private final Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        books.put(book, location);
    }

    public String removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return books.remove(book);
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = books.get(book);
        if (location == null) {
            throw new NoSuchElementException(BOOK_NOT_FOUND.formatted(book));
        }
        return location;
    }

    public String printAllBooks() {
        StringBuilder booksInfo = new StringBuilder();
        books.forEach((book, location) -> booksInfo.append(BOOK_INFO.formatted(book, location)));
        return booksInfo.toString();
    }
}
