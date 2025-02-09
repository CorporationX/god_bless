package school.faang.task57219.library;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final Map<Book, String> BOOK_INFO = new HashMap<>();

    public static void addBook(String title, String author, int year, String location) {
        BOOK_INFO.putIfAbsent(new Book(title, author, year), location);
    }

    public static void removeBook(String title, String author, int year) {
        BOOK_INFO.remove(new Book(title, author, year));
    }

    public static void findBook(String title, String author, int year) {
        System.out.println(BOOK_INFO.getOrDefault(new Book(title, author, year), "Книга не найдена."));
    }

    public static void printAllBooks() {
        for (Map.Entry<Book, String> entry : BOOK_INFO.entrySet()) {
            System.out.println(entry);
        }
    }
}
