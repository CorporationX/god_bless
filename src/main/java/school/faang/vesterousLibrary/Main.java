package school.faang.vesterousLibrary;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> BOOKS = new HashMap<>();

    public static void main(String[] args) {
        Book encyclopedia = new Book("Dinosaurs", "Someone", 1995);
        Book fairyTails = new Book("Thumbelina", "Hans Anderson", 1848);

        add(encyclopedia, "Row 10");
        add(fairyTails, "Row 5");

        remove("Thumbelina", "Hans Anderson", 1848);
        remove("Dinosaurs", "WRONG AUTHOR", 1995);
        printAllBooks();

        add(new Book("My struggle", "Bad guy", 1941), "Garbage can");
        printInfo("Dinosaurs", "WRONG AUTHOR", 1995);
        printInfo("My struggle", "Bad guy", 1941);
        printAllBooks();
    }

    private static void add(Book book, String place) {
        BOOKS.put(book, place);
    }

    private static void remove(String title, String author, int year) {
        Book temp_book = new Book(title, author, year);
        BOOKS.remove(temp_book);
    }

    private static void printInfo(String title, String author, int year) {
        String place = BOOKS.get(new Book(title, author, year));
        if (place == null) {
            System.out.println("Can't find your book");
        } else {
            System.out.println("The book you're looking for is at " + place);
        }
    }

    private static void printAllBooks() {
        for (var entry : BOOKS.entrySet()) {
            System.out.println(entry.getKey().toString() + " is located at " + entry.getValue());
        }
    }
}
