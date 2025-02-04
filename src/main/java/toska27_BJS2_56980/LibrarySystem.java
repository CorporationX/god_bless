package toska27_BJS2_56980;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;


public class LibrarySystem {
    private Map<Book, String> library = new HashMap<>();

    private void addBook(@NonNull String title, @NonNull String author, int year, @NonNull String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
        System.out.printf("Книгу: %s , разместили на %s", book, location);
    }

    private boolean removeBook(@NonNull String title, @NonNull String author, int year) {
        Book book = new Book(title, author, year);
        return library.remove(book) != null;
    }


}
