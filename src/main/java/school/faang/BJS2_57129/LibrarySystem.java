package school.faang.BJS2_57129;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class LibrarySystem {

    private final Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        books.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        books.remove(new Book(title, author, year));
    }

    public String findBook(String title, String author, int year) {
        return books.getOrDefault(new Book(title, author, year), "Такой книги нет в библиотеке!");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey() + ", полка: " + entry.getValue());
        }
    }

}
