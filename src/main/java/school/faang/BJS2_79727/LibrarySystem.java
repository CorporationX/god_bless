package school.faang.BJS2_79727;

import school.faang.BJS2_79727.model.Book;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class LibrarySystem {
    private final Map<Book, String> booksLocations = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        var newBook = new Book(title, author, Year.of(year));
        this.booksLocations.put(newBook, location);
    }

    public boolean removeBook(String title, String author, int year) {
        var bookToRemove = new Book(title, author, Year.of(year));
        return this.booksLocations.remove(bookToRemove) != null;
    }

    public String findBook(String title, String author, int year) {
        var book = new Book(title, author, Year.of(year));
        return this.booksLocations.getOrDefault(book, "The book is not found.");
    }

    public void printAllBooks() {
        this.booksLocations.forEach((book, location) -> {
            System.out.printf("%s is placed %s%n", book.getTitle(), location);
        });
    }
}
