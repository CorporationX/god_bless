package school.faang.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibrarySystem {
    private final HashMap<Book, String> library = new HashMap<>();

    public String addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        String response;

        if (!library.containsKey(book)) {
            library.put(book, location);
            response = book + " was successfully added";
            System.out.println(response);
        } else {
            response = book + " was already in library";
            System.out.println(response);
        }

        return response;
    }

    public String removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String response;

        if (library.containsKey(book)) {
            library.remove(book);
            response = book + " was successfully removed";
            System.out.println(book + " was successfully removed");
        } else {
            response = book + " does not exist";
            System.out.println(response);
        }

        return response;
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = library.get(book);

        return location == null ? "not found" : location;
    }

    public Map<String, List<Book>> printAllBooks() {
        Map<String, List<Book>> groupedLibrary = new HashMap<>();
        library.forEach((book, location) -> groupedLibrary
                .computeIfAbsent(location, k -> new ArrayList<>()).add(book));
        groupedLibrary.entrySet().forEach(System.out::println);
        return groupedLibrary;
    }
}
