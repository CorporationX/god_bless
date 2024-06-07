package faang.school.godbless.vesterros_library;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Library {
    Map<Book, String> bookMap;

    public Library() {
        this.bookMap = new HashMap<>();
    }

    public void addBookToLibrary(Book book, String positionOfBook) {
        bookMap.put(book, positionOfBook);
    }

    public void deleteBookFromLibrary(String title, String author, int year) {
        Book bookToDelete = new Book(title, author, year);
        if (bookMap.containsKey(bookToDelete)) {
            bookMap.remove(new Book(title, author, year));
        } else {
            log.warn("Could not find book: {}", bookToDelete);
        }
    }

    public void searchBookInLibrary(String title, String author, int year) {
        Book bookToSearch = new Book(title, author, year);
        if (bookMap.containsKey(bookToSearch)) {
            System.out.println(bookToSearch);
        } else {
            log.warn("Could not find book in library {}", bookToSearch);
        }
    }

    public void showAllBooksInLibrary() {
        for (Map.Entry<Book, String> book : bookMap.entrySet()) {
            System.out.println(book.getKey() + " расположена на " + book.getValue());
        }
    }
}
