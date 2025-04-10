package westeros.biblioteque;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> library = new HashMap<>();

    protected void addBook(String title, String author, int year, String location) {
        library.put(new Book(title, author, year), location);
    }

    protected void removeBook(String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    protected void findBook(String title, String author, int year) {
        String bookLocation = library.get(new Book(title, author, year));

        if (bookLocation == null) {
            System.out.printf("Book named %s is not found in library!", title);
        } else {
            System.out.printf("Book named %s is located on %s", title, bookLocation);
        }
    }

    protected void printAllBooks() {
        for (Map.Entry<Book, String> bookEntry : library.entrySet()) {
            Book key = bookEntry.getKey();
            System.out.printf("%s %s %d located on %s %n", key.getTitle(),
                    key.getAuthor(),
                    key.getYear(),
                    bookEntry.getValue());
        }
    }

}
