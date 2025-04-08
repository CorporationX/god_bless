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
        if (this.catalogue.isEmpty()) {
            log.info("Книг нет");
        } else {
            this.catalogue.forEach((book, place) ->
                    log.info("Книга {} находится в {}", book, place));
        }
    }

    protected void addBook(String title, String author, int year, String location) {
        if (!title.isEmpty() || !author.isEmpty() || !location.isEmpty()) {
            Book book = new Book(title, author, year);
            this.catalogue.put(book, location);
            log.info("Книга {} добавлена", book);
        } else {
            log.info("Проверьте корректность введённых данных");
        }
    }

    protected void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (this.catalogue.containsKey(book)) {
            this.catalogue.remove(book);
            log.info("Книга {} удалена", book);
        } else {
            throw new NoSuchElementException(String.format("Книга %s не найдена", book));
        }
    }

    protected String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (!this.catalogue.containsKey(book)) {
            throw new NoSuchElementException(String.format("Книга %s не найдена", book));
        }
        String place = this.catalogue.get(book);
        if (!place.isEmpty()) {
            return place;
        } else {
            throw new NoSuchElementException(MessageFormat.format("Книга {} не найдена", book));
        }
    }
}
