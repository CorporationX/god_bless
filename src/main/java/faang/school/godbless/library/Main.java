package faang.school.godbless.library;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<Book, String> bookMap = new HashMap<>();

    public static void main(String[] args) {
        bookMap.put(new Book("title", "author", 2024), "1");
        bookMap.put(new Book("title1", "author1", 2024), "2");
        bookMap.put(new Book("title2", "author2", 2024), "3");

        bookMap.put(new Book("title", "author", 2024), "1");
        System.out.println(bookMap.size());

        addBook(new Book("title3", "author3", 2024), "3");

        removeBook(new Book("title", "author", 2024));

        printBook(new Book("title3", "author3", 2024));

        printAllBooks();
    }

    public static void addBook(Book book, String shelf) {
        if (isValidData(book, shelf)) {
            bookMap.put(book, shelf);
        } else {
            System.out.println("Данные введены некорректно!");
        }
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

    private static boolean isValidData(Book book, String shelf) {
        return !book.getAuthor().isBlank() || !book.getTitle().isBlank() ||
                !shelf.isBlank();
    }
}
