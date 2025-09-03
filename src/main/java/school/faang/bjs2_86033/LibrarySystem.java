package school.faang.bjs2_86033;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final HashMap<Book, String> BOOK_LIBRARY = new HashMap<>();

    private LibrarySystem() {

    }

    public static void addBook(String title, String author, int year, String location) {
        BOOK_LIBRARY.put(new Book(title, author, year), location);
    }

    public static void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (BOOK_LIBRARY.containsKey(book)) {
            BOOK_LIBRARY.remove(book);
        } else {
            System.out.println("Не удалось удалить книгу. Неверно введены данные книги или такой книги нет!");
        }
    }

    public static void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (BOOK_LIBRARY.containsKey(book)) {
            System.out.println(BOOK_LIBRARY.get(book));
        } else {
            System.out.println("Такой книги нет!");
        }
    }

    public static void printAllBooks() {
        for (Map.Entry<Book, String> keyValue : BOOK_LIBRARY.entrySet()) {
            System.out.printf("%s [%s]%n", keyValue.getKey(), keyValue.getValue());
        }
    }
}