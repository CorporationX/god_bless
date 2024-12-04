package school.faang.task_45250;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> library;

    public LibrarySystem() {
        library = new HashMap<>();
    }

    public void addBook(String title, String author, Integer year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
    }

    public void removeBook(String title, String author, Integer year) {
        Book book = new Book(title, author, year);
        String shelf = library.remove(book);
        if (shelf != null) {
            System.out.println("Книга удалена: " + book.getTitle());
        } else {
            System.out.println("Книга не найдена: " + book.getTitle());
        }
    }

    public void findBook(String title, String author, Integer year) {
        Book book = new Book(title, author, year);
        String shelf = library.get(book);
        if (shelf == null) {
            System.out.println("Книга не найдена: " + book.getTitle());
        } else {
            System.out.println("Книга найдена на полке: " + shelf);
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println("Книга: " + entry.getKey().getTitle() + ", местонахождение: " + entry.getValue());
        }
    }
}
