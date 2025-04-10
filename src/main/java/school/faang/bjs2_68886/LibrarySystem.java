package school.faang.bjs2_68886;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LibrarySystem {
    private final Map<Book, String> booksWithLocations = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        booksWithLocations.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        Book bookToBeRemoved = new Book(title, author, year);
        booksWithLocations.remove(bookToBeRemoved);
    }

    public boolean findBook(String title, String author, int year) {
        Book bookToBeFound = new Book(title, author, year);
        return booksWithLocations.containsKey(bookToBeFound);
    }

    public void printAllBooks() {
        for (Entry<Book, String> entry : booksWithLocations.entrySet()) {
            System.out.printf("Книга: %s, Где: %s\n", entry.getKey().getTitle(), entry.getValue());
        }
    }
}
