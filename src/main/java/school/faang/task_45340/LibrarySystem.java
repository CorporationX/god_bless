package school.faang.task_45340;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        books.put(book, location);
    }

    public boolean removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return books.remove(book) != null;
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return books.getOrDefault(book, "Книга не найдена в библиотеке.");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey() + " находится на полке: " + entry.getValue());
        }
    }
}
