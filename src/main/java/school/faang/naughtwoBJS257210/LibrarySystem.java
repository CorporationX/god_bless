package school.faang.naughtwoBJS257210;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LibrarySystem {

    private Map<Book, String> library = new HashMap<>();

    public LibrarySystem() {
    }

    public void addBook(String title, String author, int year, String location) {
        if (location.isBlank()) {
            throw new NullPointerException("Sector not specified");
        }
        Book key = new Book(title, author, year);
        if (!this.library.containsKey(key)) {
            this.library.put(key, location);
        }
    }

    public void removeBook(String title, String author, int year) {
        Book key = new Book(title, author, year);
        this.library.remove(key);
        System.out.println("The book has been successfully added to the library");
    }

    public Optional<String> findBook(String title, String author, int year) {
        Book key = new Book(title, author, year);
        return Optional.ofNullable(this.library.get(key));
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : this.library.entrySet()) {
            System.out.println(entry.getKey() + " is in sector " + entry.getValue() + ".");
        }
    }
}
