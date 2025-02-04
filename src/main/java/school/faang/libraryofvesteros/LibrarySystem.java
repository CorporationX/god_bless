package school.faang.libraryofvesteros;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
public class LibrarySystem {
    private static final String FORMAT_TITLE = "Title: %s, ";
    private static final String FORMAT_AUTHOR = "author: %s, ";
    private static final String FORMAT_YEAR = "year: %d, ";
    private static final String FORMAT_POSITION = "position: %s\n";

    private Map<Book, String> bookPositions = new HashMap<>();

    public void addBook(String title, String author, int year, String position) {
        if (bookInLibrary(title, author, year) == null) {
            this.bookPositions.put(new Book(title, author, year), position);
        } else {
            throw new NullPointerException("The library already has this book");
        }
    }

    public void removeBook(String title, String author, int year) {
        if (bookInLibrary(title, author, year) != null) {
            this.bookPositions.remove(bookInLibrary(title, author, year));
        } else {
            System.out.println("The book wasn't in the library.");
        }
    }

    public void findBook(String title, String author, int year) {
        if (bookInLibrary(title, author, year) != null) {
            printFormattedBook(title, author, year, bookPositions.get(bookInLibrary(title, author, year)));
            System.out.println();
        } else {
            System.out.println("The library does not have this book");
        }
    }

    public void printAllBooks() {
        this.bookPositions.forEach((book, position) ->
                printFormattedBook(book.getTitle(), book.getAuthor(), book.getYear(), position));
        System.out.println();
    }

    private Book bookInLibrary(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (this.bookPositions.containsKey(book)) {
            return book;
        }
        return null;
    }

    private void printFormattedBook(String title, String author, int year, String position) {
        System.out.printf(FORMAT_TITLE, title);
        System.out.printf(FORMAT_AUTHOR, author);
        System.out.printf(FORMAT_YEAR, year);
        System.out.printf(FORMAT_POSITION, position);
    }
}
