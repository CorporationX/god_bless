package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

    private static final Map<Book, String> BOOKS = new HashMap<>();

    public static void main(String[] args) {
        BOOKS.put(new Book("Martin Eden", "Jack London", 1909), "B45R33");
        BOOKS.put(new Book("Clean Code", "Robert Martin", 2008), "C13K14");
        BOOKS.put(new Book("Grokking Algorithms", "Aditya Bhargava", 2015), "D12M43");
        BOOKS.put(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997), "F09X44");
        BOOKS.put(new Book("Arch of Triumph", "Erich Maria Remarque", 1945), "T23M55");

        addBook(new Book("Thinking in Java", "Eckel Bruce", 1998), "S00V83");
        deleteBook("Martin Eden", "Jack London", 1909);
        findBookPlace("Clean Code", "Robert Martin", 2008);
        printAllBooks();
    }

    public static void addBook(Book book, String place) {
        Objects.requireNonNull(BOOKS);
        Objects.requireNonNull(book);
        Objects.requireNonNull(place);
        BOOKS.put(book, place);
    }

    public static void deleteBook(String title, String author, int year) {
        Objects.requireNonNull(BOOKS);
        Objects.requireNonNull(title);
        Objects.requireNonNull(author);

        Book book = new Book(title, author, year);
        String removed = BOOKS.remove(book);

        if (removed == null) {
            throw new RuntimeException(String.format("No such book: %s, %s, %d.", title, author, year));
        }
    }

    public static String findBookPlace(String title, String author, int year) {
        Objects.requireNonNull(BOOKS);
        Objects.requireNonNull(title);
        Objects.requireNonNull(author);

        Book book = new Book(title, author, year);
        String place = BOOKS.get(book);

        if (place == null) {
            throw new RuntimeException(String.format("No such book: %s, %s, %d.", title, author, year));
        } else {
            return place;
        }
    }

    public static void printAllBooks() {
        BOOKS.values().stream().forEach(System.out::println);
    }
}

