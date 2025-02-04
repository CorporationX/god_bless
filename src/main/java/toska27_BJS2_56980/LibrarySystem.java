package toska27_BJS2_56980;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;


public class LibrarySystem {
    private static final Map<Book, String> library = new HashMap<>();

    public static void addBook(Book book, @NonNull String location) {
        library.put(book, location);
        System.out.printf("Книгу \"%s\" - разместили %s\n", book.getTitle(), location);
    }

    public static boolean removeBook(Book book) {
        return library.remove(book) != null;
    }

    public static String findBook(Book book) {
        return library.getOrDefault(book, "Книга не найдена");
    }

    public static void printAllBooks() {
        for (var entry : library.entrySet()) {
            System.out.printf("Книга \"%s\" размещена %s\n", entry.getKey().getTitle(), entry.getValue());
        }
    }


}
