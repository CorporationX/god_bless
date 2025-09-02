package school.faang.bjs2_86033;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final HashMap<Book, String> BOOK_LIBRARY = new HashMap<>();

    public static void addBook(String title, String author, int year, int location) {
        String index = "" + location;
        Book book = new Book(title, author, year);
        BOOK_LIBRARY.put(book, index);
    }

    public static void removeBook(String title, String author, int year) {
        BOOK_LIBRARY.remove(new Book(author, title, year));
    }

    public static void findBook(String title, String author, int year) {
        System.out.println(BOOK_LIBRARY.get(new Book(title, author, year)));
    }

    public static void printAllBooks() {
        for (Map.Entry<Book, String> keyValue : BOOK_LIBRARY.entrySet()) {
            System.out.println(keyValue.getKey() + " [" + keyValue.getValue() + "]");
        }
    }
}
