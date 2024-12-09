package school.faang.task_45353;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String bookLocation = library.get(book);
        if (bookLocation != null) {
            System.out.println("Location of the book" + bookLocation);
        } else {
            System.out.println("Book not found!");
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println("Book name: " + entry.getKey() + " , Location: " + entry.getValue());
        }
    }
}