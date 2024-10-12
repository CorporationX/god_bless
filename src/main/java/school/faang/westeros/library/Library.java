package school.faang.westeros.library;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class Library {
    private Map<Book, String> catalog = new HashMap<>();

    public void addBook(String title, String author, int year, String shelf) {
        catalog.put(new Book(title, author, year), shelf);
    }

    public void deleteBook(String title, String author, int year) {
        catalog.remove(new Book(title, author, year));
    }

    public String searchBookShelf(String title, String author, int year) {
        String book = catalog.get(new Book(title, author, year));
        return book != null ? book : "Book not found";
    }

    public void printBooks() {
        for (Map.Entry<Book, String> book : catalog.entrySet()) {
            System.out.printf("%s - %s%n", book.getKey().getInfo(), book.getValue());
        }
    }
}
