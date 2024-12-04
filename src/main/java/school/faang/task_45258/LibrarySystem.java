package school.faang.task_45258;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> storage;

    public LibrarySystem() {
        this.storage = new HashMap<>();
    }

    public void addBook(String title, String author, int year, String place) {
        storage.put(new Book(title, author, year), place);
    }

    public void removeBook(String title, String author, int year) {
        storage.remove(new Book(title, author, year));
    }

    public void findBook(String title, String author, int year) {
        String s = storage.get(new Book(title, author, year));
        if (s == null) {
            System.out.println("Книга не найдена");
            return;
        }
        System.out.println(s);
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : storage.entrySet()) {
            System.out.println("Книга: " + entry.getKey() + " находится " + entry.getValue());
        }
    }
}
