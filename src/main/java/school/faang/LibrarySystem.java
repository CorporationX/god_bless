package school.faang;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    private Map<Book, String> library = new HashMap<>();

    public LibrarySystem() {
    }

    public void addBook(String title, String author, int year, String location) {
        Book key = new Book(title, author, year);
        if (!this.library.containsKey(key)) {
            this.library.put(key, location);
        }
    }

    public void removeBook(String title, String author, int year) {
        Book key = new Book(title, author, year);
        this.library.remove(key);
    }

    public String findBook(String title, String author, int year) {
        Book key = new Book(title, author, year);
        return this.library.get(key);
    }

    public void printAllBook() {
        for (Map.Entry<Book, String> entry : this.library.entrySet()) {
            System.out.println(entry.getKey() + " is in sector " + entry.getValue() + ".");
        }
    }
}
