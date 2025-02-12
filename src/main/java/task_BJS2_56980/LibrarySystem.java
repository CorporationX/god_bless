package task_BJS2_56980;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;


public class LibrarySystem {
    private static final Map<Book, String> library = new HashMap<>();

    public static void addBook(@NonNull String title, @NonNull String author, int year, @NonNull String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
        System.out.printf("Книгу \"%s\" - разместили %s\n", book.getTitle(), location);
    }

    public static boolean removeBook(@NonNull String title, @NonNull String author, int year) {
        Book book = new Book(title, author, year);
        return library.remove(book) != null;
    }

    public static String findBook(@NonNull String title, @NonNull String author, int year) {
        Book book = new Book(title, author, year);
        return library.getOrDefault(book, "Книга не найдена");
    }

    public static void printAllBooks() {
        for (var entry : library.entrySet()) {
            System.out.printf("Книга \"%s\" размещена %s\n", entry.getKey().getTitle(), entry.getValue());
        }
    }


}
