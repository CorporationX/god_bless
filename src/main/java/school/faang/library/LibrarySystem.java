package school.faang.library;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> library = new HashMap<Book, String>();

    public void addBook(String title, String author, int year, String location) {
        library.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = library.get(book);
        if (location != null) {
            System.out.println("Book is found");
            return location;
        } else {
            System.out.println("Book not found");
            return "";
        }
    }

    public void printAllBooks() {
        library.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
