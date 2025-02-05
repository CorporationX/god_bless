package school.faang.library_of_westeros;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode
@Slf4j
@ToString

public class LibrarySystem {

    Map<Book, String> locationBook = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {

        Book book = new Book(title, author, year);
        if (locationBook.containsKey(book)) {
            log.error("Ошибка,книга уже существует.");
            throw new IllegalArgumentException("Книга уже существует в библиотеке.");
        } else {
            locationBook.put(book, location);
        }
//
//    public void removeBook(String title, String author, int year) (
//            Book book = new Book(title, author, year) {
//
//            }

    }
}
