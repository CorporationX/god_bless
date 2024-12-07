package school.faang.task_45328;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class LibrarySystem {
    private final Map<Book, String> booksLocation;

    public LibrarySystem(Map<Book, String> booksLocation) {
        this.booksLocation = booksLocation;
    }

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        if (!booksLocation.containsKey(book)) {
            booksLocation.put(book, location);
            log.info("The book {} has been successfully added", book);
        } else {
            log.info("The book {} could not be added", book);
        }
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (booksLocation.containsKey(book)) {
            booksLocation.remove(book);
            log.info("The book {} has been removed", book);
        } else {
            log.info("The book {} not found", book);
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (booksLocation.containsKey(book)) {
            log.info("The book {} located on {}", book, booksLocation.get(book));
        } else {
            log.info("The book {} not found", book);
        }
    }

    public void printAllBooks() {
        booksLocation.forEach((key, value) -> System.out.println(key + " - " + value));
    }


}
