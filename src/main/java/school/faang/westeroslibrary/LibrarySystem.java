package school.faang.westeroslibrary;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LibrarySystem {
    private final Map<Book, String> bookLocationMap = new HashMap<>();

    public void addBook(Book book, String location) {
        this.bookLocationMap.put(book, location);
    }

    public String getBookLocation(Book book) {
        return this.bookLocationMap.get(book) != null
                ? this.bookLocationMap.get(book) : "Книга " + book.getTitle() + "в библиотеке на найдена.";
    }

    public boolean removeBook(String title, String author, int year) {
        Book searchKey = new Book(title, author, year);
        String removedLocation = this.bookLocationMap.remove(searchKey);
        return removedLocation != null;
    }

    public void printAllBooks() {
        log.info("Books in the library:");
        this.bookLocationMap.forEach((book, location) ->
                log.info("{} → Shelf: {}", book.getTitle(), location)
        );
    }
}
