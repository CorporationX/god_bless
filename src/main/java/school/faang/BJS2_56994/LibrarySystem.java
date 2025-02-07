package school.faang.BJS2_56994;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LibrarySystem {
    private static final Map<Book, String> bookShelfMap = new ConcurrentHashMap<>();

    // Formatting Constants
    private static final String HEADER = "📚 Список всех книг в библиотеке:";
    private static final String TABLE_BORDER =
            "------------------------------------------------------------------------------";
    private static final String TABLE_HEADER = "| %-35s | %-20s | %-6s | %-10s |%n";
    private static final String TABLE_ROW = "| %-35s | %-20s | %-6d | %-10s |%n";
    private static final String EMPTY_LIBRARY_MESSAGE = "📚 Библиотека пуста! Нет доступных книг.";
    private static final String BOOK_NOT_FOUND_MESSAGE = "Книга с такими параметрами не найдена.";
    private static final String BOOK_LOCATION_MESSAGE = "Местоположение книги: %s%n";
    private static final String THROW_ADDBOOK_MESSAGE_TEXT =
            "Параметры title, author и location не могут быть null или пустыми строками";
    private static final String THROW_ADDBOOK_MESSAGE_YEAR = "Год должен быть четырёхзначным числом.";

    private static Map<Book, String> getBookShelfMap() {
        return bookShelfMap;
    }

    public static void addBook(String title, String author, int year, String location) {
        if (title == null || title.trim().isEmpty()
                || author == null || author.trim().isEmpty()
                || location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException(THROW_ADDBOOK_MESSAGE_TEXT);
        }

        if (year < 1000 || year > 9999) {
            throw new IllegalArgumentException(THROW_ADDBOOK_MESSAGE_YEAR);
        }

        Book newBook = new Book(title, author, year);
        bookShelfMap.put(newBook, location);
    }

    public static void removeBook(String title, String author, int year) {
        bookShelfMap.entrySet().removeIf(entry ->
                entry.getKey().getTitle().equals(title)
                        && entry.getKey().getAuthor().equals(author)
                        && entry.getKey().getYear() == year
        );
    }

    public static void findBook(String title, String author, int year) {
        for (Map.Entry<Book, String> entry : getBookShelfMap().entrySet()) {
            Book book = entry.getKey();
            if (book.getTitle().equals(title) && book.getAuthor().equals(author) && book.getYear() == year) {
                System.out.printf(BOOK_LOCATION_MESSAGE, entry.getValue());
                return;
            }
        }
        System.out.println(BOOK_NOT_FOUND_MESSAGE);
    }

    public static void printAllBooks() {
        if (getBookShelfMap().isEmpty()) {
            System.out.println(EMPTY_LIBRARY_MESSAGE);
            return;
        }

        System.out.println(HEADER);
        System.out.println(TABLE_BORDER);
        System.out.printf(TABLE_HEADER, "Название", "Автор", "Год", "Полка");
        System.out.println(TABLE_BORDER);

        getBookShelfMap().forEach((book, location) ->
                System.out.printf(TABLE_ROW, book.getTitle(), book.getAuthor(), book.getYear(), location)
        );

        System.out.println(TABLE_BORDER);
    }
}
