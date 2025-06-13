package school.faang.task_79751;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> locations = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        locations.putIfAbsent(book, location);
    }

    public  void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        locations.remove(book);
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        System.out.println(locations.getOrDefault(book, "Книга не найде"));
    }

    public void printAllBooks(){
        locations.forEach(((book, s) -> System.out.println(book.toString() + " " + s)));
    }
}
