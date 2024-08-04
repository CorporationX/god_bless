package faang.school.godbless.library;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<Book, String> bookMap = new HashMap<>();

    public static void main(String[] args) {
        bookMap.put(new Book("title", "author", 2024), "1");
        bookMap.put(new Book("title1", "author1", 2024), "2");
        bookMap.put(new Book("title2", "author2", 2024), "3");
        System.out.println(bookMap.size());

        addBook(new Book("title3", "author3", 2024), "3");

        removeBook("title", "author", 2024);

        printBook("title3", "author3", 2024);

        printAllBooks();
    }

    public static void addBook(Book book, String shelf) {
        bookMap.put(book, shelf);
    }

    public static void removeBook(String title, String author, int age) {
        bookMap.remove(new Book(title, author, age));
    }

    public static void printBook(String title, String author, int age) {
        Book book = new Book(title, author, age);

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
