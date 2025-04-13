package school.faang.bjs2_68734;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
        System.out.printf("The book %s is added at location: %s.%n", book, location);
    }

    public boolean removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return library.remove(book) != null;
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return library.getOrDefault(book, "The book was not found.");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.printf("%s is located at %s", entry.getKey(), entry.getValue());
        }
    }
}
