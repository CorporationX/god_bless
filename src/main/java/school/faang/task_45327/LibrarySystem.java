package school.faang.task_45327;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    Map<Book, String> lib = Main.getMap();

    public void addBook(String title, String author, int year, String location) {
        Book newBook = new Book(title, author, year);
        lib.put(newBook, location);
    }

    public void removeBook(String title, String author, int year) {
        Book toRemove = findBook(title, author, year);
        if (toRemove != null) {
            lib.remove(findBook(title, author, year));
        } else {
            System.out.println("There is no book with this parameters :( sorry brosito");
        }
    }

    public Book findBook(String title, String author, int year) {
        Book compareBook = new Book(title, author, year);

        return lib.keySet().stream()
                .filter(book -> book.equals(compareBook))
                .findAny()
                .orElse(null);
    }

    public void printAllBooks() {
        lib.forEach((book, location) -> System.out.println("Book: " + book + " located at: " + location));
    }
}
