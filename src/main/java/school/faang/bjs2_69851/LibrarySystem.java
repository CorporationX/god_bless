package school.faang.bjs2_69851;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> storage = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        var book = new Book(title, author, year);
        storage.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        var book = new Book(title, author, year);
        storage.remove(book);
    }

    public void findBook(String title, String author, int year) {
        var book = new Book(title, author, year);
        var location = storage.get(book);
        if (location == null) {
            System.out.println("Книга отсутствует в библиотеке!");
        } else {
            System.out.println(book + ", лежит в: " + location);
        }
    }

    public void printAllBooks() {
        if (storage.isEmpty()) {
            System.out.println("В библиотеке отсутствуют книги");
            return;
        }

        for (Map.Entry<Book, String> entry : storage.entrySet()) {
            System.out.println(entry.getKey() + " лежит в " + entry.getValue());
        }
    }
}