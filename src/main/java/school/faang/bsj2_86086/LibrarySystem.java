package school.faang.bsj2_86086;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> bookLocation = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        bookLocation.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        bookLocation.remove(book);
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = bookLocation.get(book);
        if (location == null) {
            return "Книга не найдена в библиотеке";
        }
        return location;
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> pair : bookLocation.entrySet()) {
            System.out.printf("Книга : %s; расположение: %s%n", pair.getKey(), pair.getValue());
        }
    }
}
