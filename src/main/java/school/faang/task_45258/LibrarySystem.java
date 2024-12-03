package school.faang.task_45258;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> storage;

    public LibrarySystem() {
        this.storage = new HashMap<>();
    }

    public void addBook(Book book, String place) {
        storage.put(book, place);
    }

    public void removeBook(Book book) {
        storage.remove(book);
    }

    public void findBook(Book book) {
        String s = storage.get(book);
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
