package school.faang.bjs2_68771;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    public static final String BOOK_NOT_FOUND = "Книга не найдена: %s";
    public static final String BOOK_INFO = "Книга: %s; Расположение: %s\n";

    private final Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        books.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        books.remove(book);
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return books.getOrDefault(book, BOOK_NOT_FOUND.formatted(book));
    }

    public String printAllBooks() {
        StringBuilder booksInfo = new StringBuilder();
        books.forEach((book, s) -> booksInfo.append(BOOK_INFO.formatted(book, s)));
        return booksInfo.toString();
    }
}
