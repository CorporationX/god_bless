package school.faang;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book newBook = new Book(title, author, year);
        books.put(newBook, location);
    }

    public boolean removeBook(String title, String author, int year) {
        Book newBook = new Book(title, author, year);
        return books.remove(newBook) != null;
    }

    public String findBook(String title, String author, int year) {
        Book newBook = new Book(title, author, year);
        return books.getOrDefault(newBook, "Книга не найдена в библиотеке.");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey().getTitle() + " находиться на полке: " + entry.getValue());
        }
    }
}
