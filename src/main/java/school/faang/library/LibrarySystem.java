package school.faang.library;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    Map<Book, String> bookLocation = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        if (bookLocation.containsKey(new Book(title, author, year))) {
            System.out.println("Can not add the book. " + title + " is already in the library. " +
                    "Do not need the extra example");
        } else {
            bookLocation.put(new Book(title, author, year), location);
            System.out.println("Book " + title + " is added to the library. It is located in " + location);
        }
    }

    public void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        bookLocation.remove(bookToRemove);
        System.out.println("The book " + title + " is removed from the library");
    }

    public void findBook(String title, String author, int year) {
        if (bookLocation.containsKey(new Book(title, author, year))) {
            String location = bookLocation.get(new Book(title, author, year));
            System.out.println("Book " + title + " is located in " + location);
        } else {
            System.out.println("In the library there is no book " + title);
        }

    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : bookLocation.entrySet()) {
            System.out.println("Book " + entry.getKey() + " is located in " + entry.getValue());
        }
    }
}
