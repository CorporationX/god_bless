package school.faang.bjs2_79628;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        library.putIfAbsent(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        if (library.remove(new Book(title, author, year)) == null) {
            System.out.println("Book " + title + " is not exist");
        }
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

