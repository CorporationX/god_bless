package faang.school.godbless.vesterros_library;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Getter
@Setter
public class Library {
    private Map<Book, String> bookMap;

    public Library() {
        this.bookMap = new HashMap<>();
    }

    public void addBookToLibrary(Book book, String positionOfBook) {
        bookMap.put(book, positionOfBook);
    }

    public void deleteBookFromLibrary(String title, String author, int year) {
        Book bookToDelete = findBookInLibrary(title, author, year);
        if (bookToDelete == null) {
            log.warn("Could find and remove book");
        } else {
            bookMap.remove(bookToDelete);
        }
    }

    public void searchBookInLibrary(String title, String author, int year) {
        Book neededBook = findBookInLibrary(title, author, year);
        if (neededBook == null) {
            log.warn("Could find book");
        } else {
            System.out.println(neededBook);
        }
    }

    public void showAllBooksInLibrary() {
        for (Map.Entry<Book, String> book : bookMap.entrySet()) {
            System.out.println(book.getKey() + " расположена на " + book.getValue());
        }
    }

    public Book findBookInLibrary(String title, String author, int year){
        Book book = null;
        for (Map.Entry<Book, String> bookPositionEntry : bookMap.entrySet()) {
            Book bookIteration = bookPositionEntry.getKey();
            if (bookIteration.getTitle().equals(title) &&
                    bookIteration.getAuthor().equals(author) &&
                    bookIteration.getYear() == year) {
                book = bookIteration;
                break;
            }
        }
        return book;
    }
}
