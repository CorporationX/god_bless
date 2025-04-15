package school.faang.westeros_library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibrarySystem {
    Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book addBook = new Book(title, author, year);
        library.put(addBook, location);
    }

    public void removeBook(String title, String author, int year) {
        Book removeBook = new Book(title, author, year);
        library.remove(removeBook);
    }

    public String findBook(String title, String author, int year) {
        Book findBook = new Book(title, author, year);
        return library.getOrDefault(findBook, "Book not found");
    }

    public List<String> printAllBooks() {
        List<String> books = new ArrayList<>();

        for (Map.Entry<Book, String> entry : library.entrySet()) {
            books.add(entry.getKey().toString() + " - " + entry.getValue());
        }

        return books;
    }
}
