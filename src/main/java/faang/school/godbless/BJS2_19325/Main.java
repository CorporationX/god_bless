package faang.school.godbless.BJS2_19325;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> BOOKS = new HashMap<>();

    public static void main(String[] args) {
        addBook(new Book("1984", "George Orwell", 74), "B2-45");
        addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 99), "C3-67");
        addBook(new Book("To Kill a Mockingbird", "Harper Lee", 60), "A1-23");
        removeBook("The Great Gatsby", "F. Scott Fitzgerald", 99);
        searchBookAndPrintLocation("1984", "George Orwell", 74);
        printAllBooksAndLocations();
    }

    private static void addBook(Book book, String location) {
        BOOKS.put(book, location);
    }

    private static void removeBook(String title, String author, int year) {
        BOOKS.remove(new Book(title, author, year));
    }

    private static void searchBookAndPrintLocation(String title, String author, int year) {
        System.out.println("\nlocation: " + BOOKS.get(new Book(title, author, year)));
    }

    private static void printAllBooksAndLocations() {
        for (var book : BOOKS.entrySet()) {
            System.out.println(book.getKey() + "\nlocation: " + book.getValue());
        }
    }
}
