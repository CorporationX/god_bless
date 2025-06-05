package school.faang.the_library_of_westeros;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> LIBRARY = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        LIBRARY.putIfAbsent(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        LIBRARY.remove(new Book(title, author, year));
    }

    public void findBook(String title, String author, int year) {
        System.out.println(LIBRARY.getOrDefault(new Book(title, author, year), String.format("\"Book %s not found\"", title)));
    }

    public void printAllBooks() {
        for (Book book : LIBRARY.keySet()) {
            System.out.printf("Title: %s (Author: %s, Year: %d) - Location: %s%n",
                    book.getTitle(), book.getAuthor(), book.getYear(), LIBRARY.get(book));
        }
    }
}
