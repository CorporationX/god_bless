package library;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
        System.out.printf("Book %s written by %s was added to the library, shelf number: %s \n",
                book.getTitle(), book.getAuthor(), location);
    }

    public boolean removeBook(String title, String author, int year) {
        return library.remove(new Book(title, author, year)) != null;
    }

    public String findBook(String title, String author, int year) {
        return library.getOrDefault(new Book(title, author, year), "Book not found");
    }

    public void printAllBooks() {
        library.forEach((book, location) -> System.out.println(book + ", shelf number: " + location));
    }
}


