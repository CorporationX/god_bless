package westeros.biblioteque;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> library = new HashMap<>();

    protected void addBook(String title, String author, int year, String location) {
        this.library.put(new Book(title, author, year), location);
    }

    protected void removeBook(String title, String author, int year) {
        if (this.library.containsKey(new Book(title, author, year))) {
            this.library.remove(new Book(title, author, year));
        } else {
            System.out.printf("Book named %s is not found in library!", title);
        }
    }

    protected void findBook(String title, String author, int year) {
        if (this.library.containsKey(new Book(title, author, year))) {
            String bookLocation = this.library.get(new Book(title, author, year));
            System.out.printf("Book named %s is located on %s", title, bookLocation);
        } else {
            System.out.printf("Book named %s is not found in library!", title);
        }
    }

    protected void printAllBooks() {
        for (Map.Entry<Book, String> bookEntry : this.library.entrySet()) {
            Book key = bookEntry.getKey();
            System.out.printf("%s %s %d located on %s %n", key.getTitle(),
                    key.getAuthor(),
                    key.getYear(),
                    bookEntry.getValue());
        }
    }

}
