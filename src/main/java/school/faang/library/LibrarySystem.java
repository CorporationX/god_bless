package school.faang.library;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final String notFound = "Book not found";
    Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        this.books.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        if (findBook(title, author, year).equals(notFound)) {
            System.out.println(notFound);
        } else {
            this.books.remove(new Book(title, author, year));
        }
    }

    public String findBook(String title, String author, int year) {
        return this.books.getOrDefault(new Book(title, author, year), notFound);
    }

    public String printAllBooks() {
        StringBuilder titles = new StringBuilder();
        for (Map.Entry<Book, String> entry : this.books.entrySet()) {
            titles.append(entry.getKey().getTitle())
                    .append(" находится тут: ")
                    .append(entry.getValue()).append("\n");
        }
        return titles.toString();
    }
}
