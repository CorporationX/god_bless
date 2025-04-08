package school.faang.bjs2_68652;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;
import java.util.Map;
import java.util.NoSuchElementException;

@Slf4j
@AllArgsConstructor
public class LibrarySystem {
    protected Map<Book, String> catalogue;

    protected void printAllBooks() {
        this.catalogue.forEach((book, place) ->
                log.info("Книга {} находится в {}", book, place));
    }

    protected void addBook(String title, String author, int year, String location) {
        this.catalogue.put(new Book(title, author, year), location);
    }

    protected void removeBook(String title, String author, int year) {
        this.catalogue.remove(new Book(title, author, year));
    }

    protected String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String place = this.catalogue.get(book);
        if (!place.isEmpty()) {
            return place;
        } else {
            throw new NoSuchElementException(MessageFormat.format("Книга {} не найдена", book));
        }
    }
}
