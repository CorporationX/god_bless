package school.faang.westeroslibrary.service;

import lombok.RequiredArgsConstructor;
import school.faang.westeroslibrary.entity.Book;

import java.util.Map;

@RequiredArgsConstructor
public class LibrarySystem {
    private final Map<Book, String> bookLocation;

    public void addBook(String title, String author, int year, String location) {
        bookLocation.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        bookLocation.remove(new Book(title, author, year));
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (bookLocation.containsKey(book)) {
            System.out.println("Location of the " + book + " " + bookLocation.get(book));
        } else {
            System.out.println(book + " not found in the library.");
        }
    }

    public void printAllBooks() {
        System.out.println("All library books:");
        for (Map.Entry<Book, String> entry : bookLocation.entrySet()) {
            System.out.println(entry.getKey() + " location: " + entry.getValue());
        }
    }
}
