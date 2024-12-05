package school.faang.vesteross;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final String WARNING_MESSAGE = "There is no such book in the library";

    private final Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String libraryId) {
        library.put(new Book(title, author, year), libraryId);
    }

    public void removeBook(String title, String author, int year) {
        if (library.remove(new Book(title, author, year)) != null) {
            System.out.println("The book was removed from the library");
        } else {
            System.out.println(WARNING_MESSAGE);
        }
    }

    public void findBook(String title, String author, int year) {
        System.out.println(library.getOrDefault(new Book(title, author, year), WARNING_MESSAGE));
    }

    public void printAllBooks() {
        if (library.isEmpty()) {
            System.out.println("The library has not any book!");
        } else {
            library.forEach((book, libId) -> System.out.println(libId + " " + book));
        }
    }
}
