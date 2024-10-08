package westeroslibrary;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> bookLocation = new HashMap<>();

    public static void main(String[] args) {
        bookLocation.put(new Book("book1", "author1", 2017), "place1");
        bookLocation.put(new Book("book2", "author2", 2019), "place2");
        bookLocation.put(new Book("book3", "author3", 2017), "place3");

        put(new Book("book4", "author4", 2045), "place4");
        remove("book2", "author2", 2019);
        printLocation("book4", "author4", 2045);
        printAllBooksAndLocations();
    }

    public static void put(Book book, String location) {
        bookLocation.put(book, location);
    }

    public static void remove(String title, String author, int year) {
        bookLocation.remove(new Book(title, author, year));
    }

    public static void printLocation(String title, String author, int year) {
        System.out.println(bookLocation.get(new Book(title, author, year)));
    }

    public static void printAllBooksAndLocations() {
        for (var entry : bookLocation.entrySet()) {
            System.out.printf("%s : %s \n", entry.getKey(), entry.getValue());
        }
    }
}
