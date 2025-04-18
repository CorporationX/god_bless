package faang.school.library;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LibrarySystem {
    Map<Book, String> bookLocations = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        this.bookLocations.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (this.bookLocations.remove(book) != null) {
            System.out.println("The was deleted ");
        } else {
            System.out.println("There's no such book in this library");
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = this.bookLocations.get(book);
        if (location != null) {
            log.info("The book was found: {} at {}", book, location);
        } else {
            System.out.println("There's no such book in this library");
        }
    }

    public void printAllBooks() {
        if (this.bookLocations.isEmpty()) {
            System.out.println("There are no books in this library");
        } else {
            for (Map.Entry entry : this.bookLocations.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
