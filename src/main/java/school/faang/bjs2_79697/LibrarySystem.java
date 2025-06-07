package school.faang.bjs2_79697;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        books.put(new Book(title, author, year), location);
    }

    public boolean removeBook(String title, String author, int year) {
        return books.remove(new Book(title, author, year)) != null;
    }

    public String findBook(String title, String author, int year) {
        return books.getOrDefault(new Book(title, author, year), "книга не найдена");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey() + " лежит на " + entry.getValue());
        }
    }
}
