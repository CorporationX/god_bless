package school.faang.task_45238;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private HashMap<Book, String> locationOfBooks;

    public LibrarySystem() {
        locationOfBooks = new HashMap<>();
    }

    public void addBook(String title, String author, int year, String location) {
        Book key = new Book(title, author, year);
        locationOfBooks.put(key, location);
    }

    public void removeBook(String title, String author, int year) {
        Book key = new Book(title, author, year);
        locationOfBooks.remove(key);
    }

    public void findBook(String title, String author, int year) {
        Book key = new Book(title, author, year);
        String location = locationOfBooks.get(key);
        if (location != null) {
            System.out.println(location);
            return;
        }
        System.out.println("Книга не найдена");
    }

    public void printAllBooks() {
        for (Map.Entry entry : locationOfBooks.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
