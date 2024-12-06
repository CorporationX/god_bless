package school.faang.libraryvesterosbjs245301;

import java.util.HashMap;
import java.util.Map;


public class LibrarySystem {
    private Map<Book, String> numberShelf = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        numberShelf.put(new Book(title, author, year), location);
        System.out.println("Book " + title + " add at shelf: " + location);
    }

    public void removeBook(String title, String author, int year) {
        if (numberShelf.remove(new Book(title, author, year)) != null) {
            System.out.println("Book " + title + " delete");
        } else {
            System.out.println("Book don't find");
        }
    }

    public void findBook(String title, String author, int year) {
        if (numberShelf.get(new Book(title, author, year)) != null) {
            System.out.println("Book " + title + " find");
        } else {
            System.out.println("Book don't find");
        }
    }

    public void printAllBooks() {
        if (numberShelf.isEmpty()) {
            System.out.println("Library is empty");
        } else {
            for (Map.Entry<Book, String> entry : numberShelf.entrySet()) {
                System.out.println(entry.getKey() + " find in " + entry.getValue());
            }
        }
    }
}
