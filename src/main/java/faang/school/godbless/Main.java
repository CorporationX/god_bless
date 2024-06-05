package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> books = new HashMap<>();
        books.put(new Book("Martin Eden", "Jack London", 1909), "B45R33");
        books.put(new Book("Clean Code", "Robert Martin", 2008), "C13K14");
        books.put(new Book("Grokking Algorithms", "Aditya Bhargava", 2015), "D12M43");
        books.put(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997), "F09X44");
        books.put(new Book("Arch of Triumph", "Erich Maria Remarque", 1945), "T23M55");

        addBook(books, new Book("Thinking in Java", "Eckel Bruce", 1998), "S00V83");
        deleteBook(books, "Martin Eden", "Jack London", 1909);
        findBookPlace(books, "Clean Code", "Robert Martin", 2008);
        printAllBooks(books);
    }

    public static void addBook(Map<Book, String> books, Book book, String place) {
        Objects.requireNonNull(books);
        Objects.requireNonNull(book);
        Objects.requireNonNull(place);
        books.put(book, place);
    }

    public static void deleteBook(Map<Book, String> books, String title, String author, int year) {
        Objects.requireNonNull(books);
        Objects.requireNonNull(title);
        Objects.requireNonNull(author);

        Book book = new Book(title, author, year);
        String removed = books.remove(book);

        if (removed == null) {
            throw new RuntimeException(String.format("No such book: %s, %s, %d.", title, author, year));
        }
    }

    public static String findBookPlace(Map<Book, String> books, String title, String author, int year) {
        Objects.requireNonNull(books);
        Objects.requireNonNull(title);
        Objects.requireNonNull(author);

        Book book = new Book(title, author, year);
        String place = books.get(book);

        if (place == null) {
            throw new RuntimeException(String.format("No such book: %s, %s, %d.", title, author, year));
        } else {
            return place;
        }
    }

    public static void printAllBooks(Map<Book, String> books) {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.printf("%s: %s\n", entry.getKey(), entry.getValue());
        }
    }
}

