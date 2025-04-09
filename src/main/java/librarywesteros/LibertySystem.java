package librarywesteros;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ToString
public class LibertySystem {
    private final Map<Book, String> liberty = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        liberty.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        if (liberty.remove(new Book(title, author, year)) == null) {
            System.out.println("В библиотеке нет данной книги");
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (liberty.containsKey(book)) {
            System.out.println(liberty.get(book));
        } else {
            throw new NoSuchElementException("Нет книги в библиотеке");
        }
    }

    public void printAllBooks() {
        System.out.println(liberty);
    }
}
