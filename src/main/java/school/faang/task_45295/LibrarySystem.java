package school.faang.task_45295;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> bookStorage;

    public LibrarySystem() {
        bookStorage = new HashMap<>();
    }

    public void addBook(String title, String author, int year, String location) {
        Book newBook = new Book(title, author, year);
        bookStorage.put(newBook, location);
    }

    public void removeBook(String title, String author, int year) {
        Book deliteBook = new Book(title, author, year);
        bookStorage.remove(deliteBook);
    }

    public void findBook(String title, String author, int year) {
        Book lookingForBook = new Book(title, author, year);
        String location = bookStorage.get(lookingForBook);
        if (location != null) {
            System.out.println(lookingForBook + " location is: " + location);
            return;
        }
        System.out.println(lookingForBook + " -- is not found");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : bookStorage.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

