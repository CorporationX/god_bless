package school.faang.the_library_of_westeros;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        library.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    public void findBook(String title, String author, int year) {
        System.out.println(library.getOrDefault(new Book(title, author, year), "No detected"));
    }

    public void printAllBooks() {
        for (Book book : library.keySet()) {
            System.out.println(book + " from " + library.get(book));
        }
    }
}
