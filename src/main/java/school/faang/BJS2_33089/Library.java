package school.faang.BJS2_33089;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Library {
    private final Map<Book, String> BOOKS_AND_LOCATION = new HashMap<>();

    private void validateBook(Book book) {
        if (book == null)
            throw new IllegalArgumentException("book cannot be null");
        if (book.getTitle().isBlank())
            throw new IllegalArgumentException("book title cannot be null");
        if (book.getAuthor().isBlank())
            throw new IllegalArgumentException("book author cannot be null");
        if (book.getYear() < 0)
            throw new IllegalArgumentException("book release year cannot be negative");
    }

    private void validateBook(String query) {
        if (query.isBlank()) {
            throw new IllegalArgumentException("this field cannot be null");
        }
    }

    private void validateBook(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("book release year cannot be negative");
        }
    }

    public void addBook(Book book, String shelf) {
        validateBook(book);

        if (shelf == null)
            throw new IllegalArgumentException("shelf cannot be null");

        BOOKS_AND_LOCATION.put(book, shelf);
        System.out.println("The book " + book.getTitle() + " has been added to the library");
    }

    public void deleteBook(String query) {
        validateBook(query);

        BOOKS_AND_LOCATION.entrySet().removeIf(books ->
                books.getKey().getTitle().equals(query) || books.getKey().getAuthor().equals(query));
    }

    public void deleteBook(int year) {
        validateBook(year);

        BOOKS_AND_LOCATION.entrySet().removeIf(books -> books.getKey().getYear() == year);
    }

    public String findBook(String query) {
        validateBook(query);

        for (Map.Entry<Book, String> entry : BOOKS_AND_LOCATION.entrySet()) {
            if (entry.getKey().getTitle().equals(query) || entry.getKey().getAuthor().equals(query)) {
                return BOOKS_AND_LOCATION.get(entry.getKey());
            }
        }
        return null;
    }

    public String findBook(int year) {
        validateBook(year);

        for (Map.Entry<Book, String> entry : BOOKS_AND_LOCATION.entrySet()) {
            if (entry.getKey().getYear() == year) {
                return BOOKS_AND_LOCATION.get(entry.getKey());
            }
        }
        return null;
    }

    public void getAllBooks() {
        if (!BOOKS_AND_LOCATION.isEmpty()) {
            for (Map.Entry<Book, String> book : BOOKS_AND_LOCATION.entrySet()) {
                System.out.println("The book " + book.getKey().getTitle() + " is located on " + book.getValue());
            }
        } else {
            System.out.println("The library is empty!");
        }
    }
}
