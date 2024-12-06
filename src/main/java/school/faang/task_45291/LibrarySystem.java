package school.faang.task_45291;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LibrarySystem {
    private final Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        books.put(book, location);
        log.info(title + " was added");
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (books.remove(book) == null) {
            log.info("There is no book with this title " + title);
        } else {
            log.info("Book with title: " + title + " was succesfully deleted");
        }
    }

    public void findBook(String title, String author, int year) {
        String book = books.get(new Book(title, author, year));
        if (book != null) {
            log.info("Book was found. Position is " + book);
        } else {
            log.info("Book with title: " + title + " was not found");
        }
    }

    public void printAllBooks() {
        for (var book : books.entrySet()) {
            System.out.println(book.getKey() + " is on position: " + book.getValue());
        }
    }
}
