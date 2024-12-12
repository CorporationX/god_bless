package school.faang.task_45327;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    Map<Book, String> lib = Main.getMap();

    public void addBook(String title, String author, int year, String location) {
        Book newBook = new Book(title, author, year);
        lib.put(newBook, location);
    }

    public boolean removeBook(String title, String author, int year) {
        Book toRemove = new Book(title, author, year);
        return lib.remove(toRemove) != null;
    }

    public String findBook(String title, String author, int year) {
        Book compareBook = new Book(title, author, year);
        return lib.get(compareBook);
    }

    public void printAllBooks() {
        lib.forEach((book, location) -> System.out.println("Book: " + book + " located at: " + location));
    }
}