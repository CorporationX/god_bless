package school.faang.westeroslibrary;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static final Map<Book, String> library = new HashMap<>(
            Map.of(
                    new Book("ВиМ", "Толстой", 1863), "b1",
                    new Book("book2", "auhtor2", 2001), "b3",
                    new Book("book3", "auhtor3", 2002), "b4",
                    new Book("book4", "auhtor4", 2001), "b3"
            )
    );

    public static void addBookToLibrary(Book book, String place) {
        library.put(book, place);
    }

    public static void removeBookFromLibrary(String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    public static String getBookPlace(String title, String author, int year) {
        return library.getOrDefault(new Book(title, author, year), "");
    }

    public static String getAllBooksWithPlace() {
        return library.entrySet().stream()
                .map(e -> "{ " + e.getKey().toString() + ", place=" + e.getValue() + " }")
                .collect(Collectors.joining("\n"));
    }
}
