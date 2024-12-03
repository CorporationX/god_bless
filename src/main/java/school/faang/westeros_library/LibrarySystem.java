package school.faang.westeros_library;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class LibrarySystem {
    private HashMap<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
        System.out.println("book " + title + " was added");
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        library.remove(book);
        System.out.println("book " + title + " was removed");
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        System.out.println("book " + title + " on cell " + library.get(book));
        return library.get(book);
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println(entry.getKey().getTitle() + " | " + entry.getKey().getAuthor() + " | " + entry.getKey().getYear() + " | " + entry.getValue());
        }
    }
}
