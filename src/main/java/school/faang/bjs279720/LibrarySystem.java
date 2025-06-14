package school.faang.bjs279720;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
        System.out.println("Book added!");
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String removed = library.remove(book);

        if (removed != null) {
            System.out.println("Book removed!");
        } else {
            System.out.println("Book not found!");
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = library.get(book);

        if (location != null) {
            System.out.printf("Book found: %s!%n", location);
        } else {
            System.out.println("Book not found!");
        }
    }

    public void printAllBooks() {
        if (library.isEmpty()) {
            System.out.println("Library is empty!");
            return;
        }
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            Book book = entry.getKey();
            String location = entry.getValue();
            System.out.printf("%s %s %d %s%n",
                    book.getTitle(),
                    book.getAuthor(),
                    book.getYear(),
                    location);
        }
    }
}