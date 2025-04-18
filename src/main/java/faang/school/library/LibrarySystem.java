package faang.school.library;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    Map<Book, String> bookLocations = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        bookLocations.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (bookLocations.remove(book) != null) {
            System.out.println("The was deleted ");
        } else {
            System.out.println("There's no such book in this library");
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = bookLocations.get(book);
        if (location != null) {
            System.out.println("The book was found" + book + " " + location);
        } else {
            System.out.println("There's no such book in this library");
        }
    }

    public void printAllBooks() {
        if (bookLocations.isEmpty()) {
            System.out.println("There are no books in this library");
        } else {
            for (Map.Entry entry : bookLocations.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
