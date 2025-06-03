package school.faang;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    static Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        library.put(new Book(title, author, year), location);
    }

    public boolean removeBook(String title, String author, int year) {
        return library.remove(new Book(title, author, year)) != null;
    }

    public String findBook(String title, String author, int year) {
        return library.getOrDefault(new Book(title, author, year), "Book is not find");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println(entry);
        }
    }
}

