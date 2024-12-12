package school.faang.bjs45371;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> bookStringMap = new HashMap<>();

    public String addBook(String title, String author, int year, String location) {
        return bookStringMap.put(new Book(title, author, year), location);
    }

    public String removeBook(String title, String author, int year) {
        return bookStringMap.remove(new Book(title, author, year));
    }

    public String findBook(String title, String author, int year) {
        String location = bookStringMap.get(new Book(title, author, year));
        if (location != null) {
            return location;
        } else {
            return "Book not found";
        }
    }

    public void printAllBooks() {
        for (var pair : bookStringMap.entrySet()) {
            System.out.println(pair.getKey() + " is located " + pair.getValue());
        }
    }
}
