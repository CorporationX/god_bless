package school.faang.bjs2_56986;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    Map<Book, String> library = new HashMap<>();

    public void addBook(Book book, String location, Map<Book, String> library) {
        library.put(book, location);
    }

    public void removeBook(Book book, Map<Book, String> library) {
        library.remove(book);
    }

    public void findBook(Book book, Map<Book, String> library) {
        if (library.containsKey(book)) {
            System.out.printf("Found book: %s\n", library.get(book));
        } else {
            System.out.printf("Book %s not found\n", book);
        }
    }

    public void printAllBooks(Map<Book, String> library) {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.printf("%s: %s\n", entry.getKey(), entry.getValue());
        }
    }

}
