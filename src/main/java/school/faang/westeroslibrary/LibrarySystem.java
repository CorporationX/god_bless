package school.faang.westeroslibrary;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> bookLocations;

    public LibrarySystem() {
        this.bookLocations = new HashMap<>();
    }

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        bookLocations.put(book, location);
        System.out.println("Книга добавлена: " + book + " на местонахождение: " + location);
    }

    public void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        if (bookLocations.remove(bookToRemove) != null) {
            System.out.println("Книга удалена");
        } else {
            System.out.println("В библиотеке нет такой книги");
        }
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return bookLocations.getOrDefault(book, "Книга не найдена в библиотеке.");
    }

    public void printAllBooks() {
        if (bookLocations.isEmpty()) {
            System.out.println("В библиотеке нет книг.");
            return;
        }
        for (Map.Entry<Book, String> entry : bookLocations.entrySet()) {
            System.out.println(entry.getKey() + " находится на полке: " + entry.getValue());
        }
    }
}
