package school.faang.the_library_of_westeros;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        library.putIfAbsent(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    public void findBook(String title, String author, int year) {
        System.out.println(library.getOrDefault(new Book(title, author, year), String.format("\"Book %s not found\"", title)));
    }

    public void printAllBooks() {
        for (Book book : library.keySet()) {
            System.out.printf("Книга: %s (Автор: %s, Год: %d) - Расположение: %s%n",
                    book.getTitle(), book.getAuthor(), book.getYear(), library.get(book));
        }
    }
}
