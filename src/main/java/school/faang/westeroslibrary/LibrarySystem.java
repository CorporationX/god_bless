package school.faang.westeroslibrary;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
public class LibrarySystem {

    private final HashMap<Book, String> bookShelves = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book newBook = new Book(title, author, year);
        bookShelves.putIfAbsent(newBook, location);
    }

    public void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        bookShelves.remove(bookToRemove);
    }

    public String findBook(String title, String author, int year) {
        Book searchBook = new Book(title, author, year);
        String location = bookShelves.get(searchBook);
        return Objects.requireNonNullElse(location, "Book was not found.");
    }

    public String printAllBooks() {
        StringBuilder allBooks = new StringBuilder();
        for (Map.Entry<Book, String> kv : bookShelves.entrySet()) {
            allBooks.append("Book: ").append(kv.getKey().getTitle()).append(" | Shelf: ").append(kv.getValue());
        }
        return allBooks.toString();
    }
}
