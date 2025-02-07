package bjs257097;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class LibrarySystem {
    Map<Book, String> booksToPlaces = new HashMap<>();

    void addBook(String title, String author, int year, String location) {
        booksToPlaces.put(new Book(title, author, year), location);
    }

    void removeBook(String title, String author, int year) {
        booksToPlaces.remove(new Book(title, author, year));
    }

    void findBook(String title, String author, int year) {
        String place = booksToPlaces.get(new Book(title, author, year));
        if (place != null) {
            System.out.printf("Book found in the library in: %s %n", place);
        } else {
            System.out.println("Book not found");
        }

    }

    void printAllBooks() {
        booksToPlaces.forEach((book, place) -> System.out.printf("Book: %s, place: %s %n", book, place));
    }
}
