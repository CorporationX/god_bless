package school.faang.westeroslibrary;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
    }

    public String removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);

        if (library.containsKey(book)) {
            return library.remove(book);
        } else {
            return null;
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            System.out.println("Your book located in " + library.get(book));
        } else {
            System.out.println("Your book was not found in library");
        }
    }

    public void printAllBooks() {
        library.forEach((key, value) -> {
            System.out.println("Book = " + key + ", Location = " + value);
        });
    }
}
