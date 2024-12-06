package school.faang.bjs245323;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    private final Map<Book, String> shelfs = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        if (title.isEmpty() || author.isEmpty() || year < 0 || location.isEmpty()) {
            throw new IllegalArgumentException("Enter truly information");
        }
        shelfs.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (!shelfs.containsKey(book)) {
            throw new RuntimeException("Book is not found !");
        }
        shelfs.remove(book);
    }

    public void findBook(String title, String author, int year) {
        shelfs.forEach((book, shelf) -> {
            if (book.getAuthor().equals(author) && book.getTitle().equals(title) && book.getYear() == year) {
                System.out.println(shelf);
            }
        });
    }

    public void printAllBook() {
        for (Book book : shelfs.keySet()) {
            System.out.println(book);
        }
    }
}
