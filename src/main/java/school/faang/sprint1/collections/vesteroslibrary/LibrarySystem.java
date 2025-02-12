package school.faang.sprint1.collections.vesteroslibrary;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import school.faang.sprint1.collections.vesteroslibrary.exceptions.BookNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LibrarySystem {
    private final String bookNotFoundMessage = "A book '%s' is not found in the library";
    private final String bookExistMessage = "A book '%s' already exists in the library";

    private Map<Book, String> libraryMap = new HashMap<>();

    public void addBook(@NonNull String title, @NonNull String author, int year, @NonNull String location) {
        Book book = new Book(title, author, year);
        if (!libraryMap.containsKey(book)) {
            libraryMap.put(book, location);
        } else {
            log.info(String.format(bookExistMessage, book.getTitle()));
        }
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (libraryMap.containsKey(book)) {
            libraryMap.remove(book);
        } else {
            log.warn(String.format(bookNotFoundMessage, book.getTitle()));
            throw new BookNotFoundException(bookNotFoundMessage, book.getTitle());
        }
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (libraryMap.containsKey(book)) {
            return libraryMap.get(book);
        } else {
            log.warn(String.format(bookNotFoundMessage, book.getTitle()));
            throw new BookNotFoundException(bookNotFoundMessage, book.getTitle());
        }
    }

    public void printAllBooks() {
        if (libraryMap.isEmpty()) {
            log.info("There are no books in the library");
        } else {
            System.out.println("---List of books in the library---");
            for (Map.Entry<Book, String> entry : libraryMap.entrySet()) {
                System.out.println("Book title: '" + entry.getKey().getTitle() + "', location: " + entry.getValue());
            }
            System.out.println("..........\n");
        }
    }
}
