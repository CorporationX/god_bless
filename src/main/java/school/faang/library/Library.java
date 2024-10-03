package school.faang.library;

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
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            Book key = entry.getKey();
            String location = entry.getValue();

            if (key.equals(book)) {
                System.out.println(key + " " + location);
            }
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            Book book = entry.getKey();
            String location = entry.getValue();
            System.out.println(book + " " + location);
        }
    }
}
