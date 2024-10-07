package school.faang.BJS2_33089;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Library {
    private Map<Book, String> bookAndLocation = new HashMap<>();

    private void validateBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("book cannot be null");
        }
        if (book.getTitle().isBlank()) {
            throw new IllegalArgumentException("book title cannot be null");
        }
        if (book.getAuthor().isBlank()) {
            throw new IllegalArgumentException("book author cannot be null");
        }
        if (book.getYear() < 0) {
            throw new IllegalArgumentException("book release year cannot be negative");
        }
    }

    public void addBook(Book book, String shelf) {
        validateBook(book);

        if (shelf == null) {
            throw new IllegalArgumentException("shelf cannot be null");
        }

        bookAndLocation.put(book, shelf);
    }

    public void deleteBook(Book book) {
        validateBook(book);

        bookAndLocation.remove(book);
    }

    public String findBook(Book book) {
        validateBook(book);

        return bookAndLocation.get(book);
    }

    public void getAllBooks() {
        if (!bookAndLocation.isEmpty()) {
            for (Map.Entry<Book, String> entry : bookAndLocation.entrySet()) {
                System.out.println("The book " + entry.getKey().getTitle() + " is located on " + entry.getValue());
            }
        } else {
            System.out.println("The library is empty!");
        }
    }
}
