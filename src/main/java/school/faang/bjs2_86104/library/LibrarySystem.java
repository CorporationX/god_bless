package school.faang.bjs2_86104.library;

import java.util.Map;
import java.util.HashMap;

import school.faang.bjs2_86104.exception.BookNotFoundException;
import school.faang.bjs2_86104.exception.BookNotValidException;
import school.faang.bjs2_86104.exception.BookshelfNotValidException;

public class LibrarySystem {
    public static final Map<Book, String> BOOKS = new HashMap<>();

    private LibrarySystem() {

    }

    public static void addBook(String title, String author, int year, String bookshelfNumber) {
        validateBookshelfNumber(bookshelfNumber);
        BOOKS.putIfAbsent(new Book(title, author, year), bookshelfNumber);
    }

    public static void removeBook(String title, String author, int year) {
        BOOKS.remove(checkBookInTheLibrary(title, author, year));
    }

    private static void validateBookshelfNumber(String bookshelfNumber) {
        if (bookshelfNumber == null || bookshelfNumber.isBlank()) {
            throw new BookshelfNotValidException("bookshelf number cannot be null, empty or a space");
        }
    }

    public static void findBook(String title, String author, int year) {
        System.out.println(BOOKS.get(checkBookInTheLibrary(title, author, year)));
    }

    private static Book checkBookInTheLibrary(String title, String author, int year) {
        try {
            BookValidator.validateBook(title, author, year);
        } catch (BookNotValidException e) {
            throw new BookNotFoundException("there is no such book in the library", e);
        }

        Book checkedBook = new Book(title, author, year);
        if (!BOOKS.containsKey(checkedBook)) {
            throw new BookNotFoundException("there is no such book in the library");
        }
        return checkedBook;
    }

    public static void printAllBooks() {
        BOOKS.forEach((book, bookShelfNumber) -> System.out.println("Книга: [" + book + "]" +
                " | Номер книжной полки: [" + bookShelfNumber + "]"));
    }
}