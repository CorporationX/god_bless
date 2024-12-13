package school.faang.sprint_1.task_45320;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            library.remove(book);
            System.out.println("Книга удалена: " + book);
        } else {
            System.out.println("Книга не найдена: " + book);
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            System.out.println("Результат:\n" + book + " находится: " + library.get(book));
        } else {
            System.out.println("Книга не найдена:\n" + book);
        }
    }

    public void printAllBooks() {
        if (library.isEmpty()) {
            System.out.println("Нет книг библиотеке.");
        } else {
            library.forEach((book, location) -> System.out.println(book + " находится: " + location));
        }
    }
}
