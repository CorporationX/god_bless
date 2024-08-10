package faang.school.godbless.library;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

    public static Map<Book, String> bookMap = new HashMap<>();

    public static void main(String[] args) {
        bookMap.put(new Book("title", "author", 2024), "1");
        bookMap.put(new Book("title1", "author1", 2024), "2");
        bookMap.put(new Book("title2", "author2", 2024), "3");
        Book book = null;

        bookMap.put(new Book("title", "author", 2024), "1");
        System.out.println(bookMap.size());

        addBook(book, "3");

        addBook(new Book("title3", "author3", 2024), "3");

        removeBook(new Book("title", "author", 2024));

        printBook(new Book("title3", "author3", 2024));

        printAllBooks();
    }

    public static void addBook(Book book, String shelf) {
        Objects.requireNonNull(book, "Объект книга не может быть null");
        bookMap.put(book, shelf);
    }

    public static void removeBook(Book book) {
        bookMap.remove(book);
    }

    public static void printBook(Book book) {
        for (Map.Entry<Book, String> entry : bookMap.entrySet()) {
            if (entry.getKey().equals(book)) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }

    public static void printAllBooks() {
        for (Map.Entry<Book, String> entry : bookMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
