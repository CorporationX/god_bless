package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> booksLocation = new HashMap<>();

    public static void main(String[] args) {
        Book book0 = new Book("Bible", "Unknown", 0);
        Book book1 = new Book("A Clockwork Orange", "Anthony Burgess", 1962);
        Book book2 = new Book("The Philosophy of Java(4th complete edition)", "Bruce Eckel", 2006);

        addBook(book0, "4-th shelf");
        addBook(book1, "1-st shelf");
        addBook(book2, "7-th shelf");

        System.out.println(searchBook("A Clockwork Orange", "Anthony Burgess", 1962));

        removeBook("A Clockwork Orange", "Anthony", 1962);
        removeBook("A Clockwork Orange", "Anthony Burgess", 1962);

        printBook();
    }

    public static void addBook(Book book, String location) {
        if (book == null || location.isEmpty()) System.out.println("Illegal title or location!");
        else booksLocation.put(book, location);
    }

    public static String searchBook(String title, String author, int age) {
        return booksLocation.get(new Book(title, author, age));
    }

    public static void removeBook(String title, String author, int age) {
        Book necessaryBook = new Book(title, author, age);

        if (booksLocation.containsKey(necessaryBook)) booksLocation.remove(necessaryBook);
        else System.out.println("There is no book: " + necessaryBook);
    }

    public static void printBook() {
        for (Book book : booksLocation.keySet()) System.out.println(book + " is on the " + booksLocation.get(book));
    }
}