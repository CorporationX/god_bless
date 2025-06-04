package school.faang.module1.bjs2_79647;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class LibrarySystem {

    private final Map<Book, String> bookLocations;

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        bookLocations.put(book, location);
        System.out.println("Book added: " + book + " location: " + location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String removedLocation = bookLocations.remove(book);
        System.out.println(removedLocation != null ? "Book removed: " + book : "Book not found for removal: " + book);
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = bookLocations.get(book);
        System.out.println(location != null ? "Book found: " + book + " location: " + location : "Book not found: " + book);
    }

    public void printAllBooks() {
        System.out.println(bookLocations.isEmpty() ? "The library is empty." : "List of all books in the library:");
        bookLocations.forEach((book, location) -> System.out.println(book + " location: " + location));
    }
}
