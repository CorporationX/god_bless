package school.faang.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LibrarySystem {
    private final HashMap<Book, String> library = new HashMap<>();

    public String addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        return library.putIfAbsent(book, location);
    }

    public String removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return library.remove(book);
    }

    public Optional<String> findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = library.get(book);

        return location == null ? Optional.empty() : Optional.of(location);
    }

    public Map<String, List<Book>> printAllBooks() {
        Map<String, List<Book>> groupedLibrary = new HashMap<>();
        library.forEach((book, location) -> groupedLibrary
                .computeIfAbsent(location, k -> new ArrayList<>()).add(book));
        groupedLibrary.entrySet().forEach(System.out::println);
        return groupedLibrary;
    }
}
