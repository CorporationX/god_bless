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
        if (!isTheLibrary(title, author, year)) {
            this.bookPositions.put(new Book(title, author, year), position);
        } else {
            throw new NullPointerException("The library already has this book");
        }
    }

    public void removeBook(String title, String author, int year) {
        if (isTheLibrary(title, author, year)) {
            this.bookPositions.remove(new Book(title, author, year));
        }
    }

    public void findBook(String title, String author, int year) {
        if (isTheLibrary(title, author, year)) {
            System.out.printf(FORMAT_TITLE, title);
            System.out.printf(FORMAT_AUTHOR, author);
            System.out.printf(FORMAT_YEAR, year);
            System.out.printf(FORMAT_POSITION + "\n", bookPositions.get(new Book(title, author, year)));
        } else {
            throw new NullPointerException("The library does not have this book");
        }
    }

    public void printAllBooks() {
        this.bookPositions.forEach((book, position) -> {
            System.out.printf(FORMAT_TITLE, book.getTitle());
            System.out.printf(FORMAT_AUTHOR, book.getAuthor());
            System.out.printf(FORMAT_YEAR, book.getYear());
            System.out.printf(FORMAT_POSITION, position);
        });
        System.out.println();
    }

    private boolean isTheLibrary(String title, String author, int year) {
        return this.bookPositions.containsKey(new Book(title, author, year));
    }
}
