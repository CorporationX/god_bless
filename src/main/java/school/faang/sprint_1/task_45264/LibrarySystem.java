package school.faang.sprint_1.task_45264;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> booksLocation = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = createBook(title, author, year);
        booksLocation.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = createBook(title, author, year);
        booksLocation.remove(book);
    }

    public String findBook(String title, String author, int year) {
        Book book = createBook(title, author, year);
        return booksLocation.getOrDefault(book, "notFound");
    }

    public void printAllBooks() {
        for (var book : booksLocation.entrySet()) {
            System.out.println(book.getKey().toString() + " : " + book.getValue());
        }
    }

    private Book createBook(String title, String author, int year) {
        return new Book(title, author, year);
    }

}
