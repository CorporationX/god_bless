package school.faang.libraryofwesteros;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> library = new HashMap<>();

    public void addBook(Book book, String location) {
        library.put(book, location);
    }

    public void removeBook(Book book) {
        if (library.containsKey(book)) {
            library.remove(book);
            System.out.println("Книга удалена: " + book);
        } else {
            System.out.println("Книга не найдена.");
        }
    }

    public void findBook(Book book) {
        String location = library.get(book);
        if (location != null) {
            System.out.println("Местонахождение книги: " + location);
        } else {
            System.out.println("Книга не найдена.");
        }
    }

    public void printAllBooks() {
        if (library.isEmpty()) {
            System.out.println("Библиотека пуста.");
        }
        library.forEach((book, location) ->
                System.out.println(book + " - находится: " + location));
    }
}
