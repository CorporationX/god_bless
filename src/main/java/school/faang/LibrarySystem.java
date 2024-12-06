package school.faang;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> library;

    public LibrarySystem() {
        this.library = new HashMap<>();
    }

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
        System.out.println("Книга добавлена: " + book + " на полке " + location);
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
        String location = library.get(book);
        if (location != null) {
            System.out.println("Книга найдена: " + book + " находится на полке " + location);
        } else {
            System.out.println("Книга не найдена: " + book);
        }
    }

    public void printAllBooks() {
        if (library.isEmpty()) {
            System.out.println("Библиотека пуста.");
        } else {
            System.out.println("Список всех книг в библиотеке:");
            for (Map.Entry<Book, String> entry : library.entrySet()) {
                System.out.println(entry.getKey() + " находится на полке " + entry.getValue());
            }
        }
    }
}
