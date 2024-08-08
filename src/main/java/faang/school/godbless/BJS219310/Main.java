package faang.school.godbless.BJS219310;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> libraryBooks = new HashMap<>();

    public static void addBookToPlace(Book book, String location) {
        libraryBooks.put(book, location);
    }

    public static void deleteBook(String title, String author, int year) {
        Book bookToDelete = new Book(title, author, year);
        if (libraryBooks.containsKey(bookToDelete)) {
            libraryBooks.remove(bookToDelete);
        } else {
            System.out.println("Book not found.");
        }
    }

    public static void searchForBookLocation(String title, String author, int year) {
        System.out.println("Place: " + libraryBooks.get(new Book(title, author, year)));
    }

    private static void printAllBooksAndLocations() {
        for (var book : libraryBooks.entrySet()) {
            System.out.println(book.getKey() + " location: " + book.getValue());
        }
    }

    public static void main(String[] args) {
        Book book1 = new Book("Java", "Mike Stepanov", 1999);
        Book book2 = new Book("Python", "Misha Smith", 2000);
        Book book3 = new Book("Kotlin", "Stive Gorbunov", 2001);

        addBookToPlace(book1, "101");
        addBookToPlace(book2, "202");
        addBookToPlace(book3, "303");

        deleteBook("Kotlin", "Stive Gorbunov", 2001);
        searchForBookLocation("Python", "Misha Smith", 2000);
        printAllBooksAndLocations();
    }
}
