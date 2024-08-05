package faang.school.godbless.vesterosLibrary;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<>();
        Book book1 = new Book("Harry Potter and Philosopher's Stone", "J. K. Rowling", 1997);
        Book book2 = new Book("Dune", "Frank Herbert", 1965);
        Book book3 = new Book("Fifty Shades of Grey", "E. L. James", 2011);

        addBook(library, book1, "1A");
        addBook(library, book2, "2B");
        addBook(library, book3, "3C");

        showLibrary(library);
        System.out.println();

        removeBook(library, "Fifty Shades of Grey", "E. L. James", 2011);
        removeBook(library, "Harry Potter and Philosopher's Stone", "J. K. Rowling", 1997);

        showLibrary(library);
        System.out.println();

        bookLocation(library, "Dune", "Frank Herbert", 1965);
        System.out.println();

        bookLocation(library, "Harry Potter and Philosopher's Stone", "J. K. Rowling", 1997);
    }

    private static void addBook(Map<Book, String> library, Book book, String shelf) {
        library.put(book, shelf);
    }

    private static void removeBook(Map<Book, String> library, String title, String author, int year) {
        Book book = getBookByNameAuthorYear(library, title, author, year);
        if (book == null) {
            System.out.println("Book not found");
            return;
        }
        library.remove(book);
    }

    private static void bookLocation(Map<Book, String> library, String title, String author, int year) {
        Book book = getBookByNameAuthorYear(library, title, author, year);
        if (book == null) {
            System.out.println("Book not found");
            return;
        }
        System.out.println("Shelf: " + library.get(book));
    }

    private static void showLibrary(Map<Book, String> library) {
        library.forEach((book, shelf) ->
                System.out.println("Shelf: " + shelf +
                        ", Title: " + book.getTitle() +
                        ", Author: " + book.getAuthor() +
                        ", written in: " + book.getYear()));
    }

    private static Book getBookByNameAuthorYear(Map<Book, String> library, String title, String author, int year) {
        return library.keySet()
                .stream()
                .filter(book -> book.equals(new Book(title, author, year)))
                .findFirst()
                .orElse(null);
    }
}
