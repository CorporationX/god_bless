package school.faang.bjs2_68666;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LibrarySystem {
    private static final Map<Book, String> BOOKS_PLACE = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        BOOKS_PLACE.put(new Book(title, author, year), location);
    }

    public String findBook(String title, String author, int year) {
        String location;
        Book book = new Book(title, author, year);
        location = BOOKS_PLACE.getOrDefault(book, "book not found");

        return location;
    }
    
    public void removeBook(String title, String author, int year) {
        if (!Objects.equals(findBook(title, author, year), "book not found")) {
            BOOKS_PLACE.remove(new Book(title, author, year));
        }
    }
    
    public List<String> printAllBooks() {
        List<String> bookList = new ArrayList<>();
        for (Map.Entry<Book, String> entry : BOOKS_PLACE.entrySet()) {
            bookList.add(entry.getKey().toString() + " on " + entry.getValue());
        }

        return bookList;
    }
}
