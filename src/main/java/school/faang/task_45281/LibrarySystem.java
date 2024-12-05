package school.faang.task_45281;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class LibrarySystem {

    private final Map<Book, String> booksLocations = new HashMap<>();

    public LibrarySystem(Map<Book, String> books) {
        this.booksLocations.putAll(books);
    }

    public void addBook(String title, String author, int year, String location) {
        booksLocations.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        booksLocations.remove(book);
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return booksLocations.getOrDefault(book, "Book is not found in library");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : booksLocations.entrySet()) {
            Book book = entry.getKey();
            String location = entry.getValue();
            System.out.println(book.getTitle() + ", " + book.getAuthor() + ", "
                    + book.getYear() + " -  находится: " + location);
        }
    }
}