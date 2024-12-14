package school.faang.library33058;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private static final Map<Book, String> map = new HashMap<>();

    public void addBook(Book book, String location) {
        map.put(book, location);
    }

    public void deleteBook(String name, String author, int year) {
        Book book = new Book(name, author, year);
        map.remove(book);
    }

    public void searchBook(String name, String author, int year) {
        Book book = new Book(name, author, year);
        String location = map.getOrDefault(book, "Location not found");
        System.out.println(book + " " + location);
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            Book book = entry.getKey();
            String location = entry.getValue();
            System.out.println(book + " " + location);
        }
    }
}
