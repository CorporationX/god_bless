package faang.school.godbless.library;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    private static final Map<Book, String> BOOKS = new HashMap<>();

    public static void main(String[] args) {
        try {
            addBook(new Book("Onegin", "Pushkin", 1862), "Shelf 1");
            addBook(new Book("Voina i mir", "Tolstoi", 1802), "Shelf 3");
            addBook(new Book("Demons", "Dostoevsky", 1822), "Shelf 1");

            printAllBooks();
            deleteBook("Demons", "Dostoevsky", 1822);
            findBook("Onegin", "Pushkin", 1862);
            findBook("Demons", "Dostoevsky", 1822);
            printAllBooks();
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Check input data! ");
        }
    }

    public static void addBook(Book book, String shelf) {
        Objects.requireNonNull(book);
        Objects.requireNonNull(shelf);
        BOOKS.put(book, shelf);
        System.out.println("Book \"" + book.title() + "\" is added on shelf : \"" + shelf + "\" successfully.");

    }

    public static void deleteBook(String title, String author, int year) {
        Objects.requireNonNull(BOOKS);
        Objects.requireNonNull(title);
        Objects.requireNonNull(author);
        Book book = new Book(title, author, year);
        if (BOOKS.remove(book) != null) {
            System.out.println("Book : \"" + title + "\" removed successfully");
        } else {
            throw new BookNotFoundException("Book : \"" + title + "\" is not deleted");
        }
    }

    public static void findBook(String title, String author, int year) {
        Objects.requireNonNull(title);
        Objects.requireNonNull(author);
        Book book = new Book(title, author, year);
        if (BOOKS.containsKey(book)) {
            System.out.println("Book : \"" + title + "\" is found on shelf : \"" + BOOKS.get(book) + "\"");
        } else {
            throw new BookNotFoundException("Book with title: \"" + title + "\"" +
                    " author: \"" + author + "\"" +
                    " year: \"" + year + "\"" +
                    " is not found");
        }
    }

    public static void printAllBooks() {
        BOOKS.forEach((k, v) -> System.out.println(k + " on shelf : " + v));
    }
}
