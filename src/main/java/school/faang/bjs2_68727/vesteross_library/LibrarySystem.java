package school.faang.bjs2_68727.vesteross_library;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Getter
@Slf4j
public class LibrarySystem {
    private static final String BOOK_NOT_FOUND = "Book with title {}, author {}, year {} is not found";
    Map<Book, String> libraryMap = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        libraryMap.putIfAbsent(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        this.findBook(title, author, year);
        libraryMap.remove(new Book(title, author, year));
    }

    public String findBook(String title, String author, int year) {
        String location = libraryMap.get(new Book(title, author, year));
        if (location == null) {
            log.error(BOOK_NOT_FOUND, title, author, year);
        }
        return location;
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : libraryMap.entrySet()) {
            log.info("Book: {}, location: {}", entry.getKey(), entry.getValue());
        }
    }
}
