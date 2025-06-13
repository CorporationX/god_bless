package school.faang.bjs279727;

import school.faang.bjs279727.model.Book;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> locationByBook = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        var newBook = new Book(title, author, Year.of(year));
        this.locationByBook.put(newBook, location);
    }

    public boolean removeBook(String title, String author, int year) {
        var bookToRemove = new Book(title, author, Year.of(year));
        return this.locationByBook.remove(bookToRemove) != null;
    }

    public String findBook(String title, String author, int year) {
        var book = new Book(title, author, Year.of(year));
        return this.locationByBook.getOrDefault(book, "The book is not found.");
    }

    public void printAllBooks() {
        this.locationByBook.forEach((book, location) -> {
            System.out.printf("%s is placed %s%n", book.getTitle(), location);
        });
    }
}
