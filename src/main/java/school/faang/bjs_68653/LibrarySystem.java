package school.faang.bjs_68653;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;
import java.util.NoSuchElementException;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class LibrarySystem {

    private Map<Book, String> books;

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        books.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        books.remove(getBook(title, author, year));
    }

    public void findBook(String title, String author, int year) {
        books.get(getBook(title, author, year));
    }

    public void printAllBooks() {
        books.forEach((book, location) -> {
            System.out.println("Book: " + book + " is located at: " + location + "\n");
        });

    }

    public Book getBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (!books.containsKey(book)) {
            throw new NoSuchElementException("Book not found");
        }
        return book;
    }
}
