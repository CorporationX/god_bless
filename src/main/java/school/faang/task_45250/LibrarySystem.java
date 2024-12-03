package school.faang.task_45250;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> library;

    public LibrarySystem() {
        library = new HashMap();
    }

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        library.remove(book);
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (!library.containsKey(book)) {
            System.out.println("123");
        }
        return library.get(book);
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println("Книга: " + entry.getKey() + ", местонахождение: " + entry.getValue());
        }
    }
}
