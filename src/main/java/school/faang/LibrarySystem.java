package school.faang;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    HashMap<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
    }

    public boolean removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return library.remove(book) != null;
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        //return library.containsKey(book);
        return library.getOrDefault(book, "No book found");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println(entry.getKey() + " is here: " + entry.getValue());
        }
    }
}
