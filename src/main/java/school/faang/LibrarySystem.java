package school.faang;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> bookLocationMap = new HashMap<>();

    public void addBook(Book book, String location) {
        bookLocationMap.put(book, location);
    }

    public String getBookLocation(Book book) {
        return bookLocationMap.get(book);
    }

    public boolean removeBook(String title, String author, int year) {
        Book searchKey = new Book(title, author, year);

        String removedLocation = bookLocationMap.remove(searchKey);
        return removedLocation != null;
    }

    public void printAllBooks() {
        System.out.println("Books in the library:");
        bookLocationMap.forEach((book, location) ->
                System.out.println(book + " → Shelf: " + location)
        );
    }
}
