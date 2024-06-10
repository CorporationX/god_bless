package faang.school.godbless.westeros_library;

import java.util.HashMap;
import java.util.Map;

public class Main {
    HashMap<Book, String> books = new HashMap<>();

    public Main() {
        books.put(new Book("Dragons", "Targaryen", 234), "Row 10, shelf 15");
        books.put(new Book("Resurrection", "Snow", 303), "Row 1, shelf 13");
        books.put(new Book("Mad King", "Lannister", 264), "Row 154, shelf 11");
    }

    public void addBook(Book book, String location) {
        books.put(book, location);
    }

    public void burnBook(String title, String author, int year) {
        books.remove(new Book(title, author, year));
    }

    public String askLibrarianWhereBook(String author, String location, int year) {
        return books.get(new Book(author, location, year));
    }

    public void libraryInspection() {
        System.out.println(books.entrySet());
    }
}
