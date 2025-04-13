package school.faang;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        books.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        books.remove(new Book(title, author, year));
    }

    public String findBook(String title, String author, int year) {
        return books.getOrDefault(new Book(title, author, year), "Book not found");
    }

    public String printAllBooks() {
        StringBuilder titles = new StringBuilder();
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            titles.append(entry.getKey().getTitle())
                    .append(" находится тут: ")
                    .append(entry.getValue()).append("\n");
        }
        return titles.toString();
    }
}
