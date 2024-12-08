package school.faang.task_45300;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class LibrarySystem {
    HashMap<Book, String> booksMap = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);

        booksMap.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);

        if (booksMap.containsKey(book)) {
            booksMap.remove(book);
            System.out.println("Book: " + title + " " + author + " " + year + " is remove");
        } else {
            System.out.println("Book: " + title + " " + author + " " + year + " for remove not found");
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);

        if (booksMap.containsKey(book)) {
            System.out.println("Book: " + title + " " + author + " " + year + " location on " + booksMap.get(book));
        } else {
            System.out.println("Book: " + title + " " + author + " " + year + " not found");
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : booksMap.entrySet()) {
            Book key = entry.getKey();
            String value = entry.getValue();

            System.out.println("Book: " + key + " , location: " + value);
        }
    }
}
