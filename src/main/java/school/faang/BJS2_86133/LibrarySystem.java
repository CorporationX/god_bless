package school.faang.BJS2_86133;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book newBook = new Book(title, author, year);
        library.put(newBook, location);
    }

    public void removeBook(String title, String author, int year) {
        Book bookShouldRemove = new Book(title, author, year);
        library.remove(bookShouldRemove);
    }

    public String findBook(String title, String author, int year) {
        Book searchBook = new Book(title, author, year);
        if (!library.containsKey(searchBook)) {
            throw new IllegalArgumentException("This book doesn't exist");
        }
        return library.get(searchBook);
    }

    public void printAllBooks() {
        System.out.println(library);
    }
}
