package school.faang.sprint1.collections.vesteroslibrary;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import school.faang.sprint1.collections.vesteroslibrary.exceptions.BookNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LibrarySystem {
    public static final  String BOOK_NOT_FOUND_MESSAGE = "A book '%s' is not found in the library";
    public static final  String BOOK_EXIST_MESSAGE = "A book '%s' already exists in the library";

    private Map<Book, String> libraryMap = new HashMap<>();

    public void addBook(@NonNull String title, @NonNull String author, int year, @NonNull String location) {
        Book book = new Book(title, author, year);
        if (!libraryMap.containsKey(book)) {
            libraryMap.put(book, location);
        } else {
            log.info(String.format(BOOK_EXIST_MESSAGE, book.getTitle()));
        }
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (libraryMap.containsKey(book)) {
            libraryMap.remove(book);
        } else {
            log.warn(String.format(BOOK_NOT_FOUND_MESSAGE, book.getTitle()));
            throw new BookNotFoundException(BOOK_NOT_FOUND_MESSAGE, book.getTitle());
        }
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (libraryMap.containsKey(book)) {
            return libraryMap.get(book);
        } else {
            log.warn(String.format(BOOK_NOT_FOUND_MESSAGE, book.getTitle()));
            throw new BookNotFoundException(BOOK_NOT_FOUND_MESSAGE, book.getTitle());
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
