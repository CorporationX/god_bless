package school.faang.westуros_library;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> library;

    public LibrarySystem() {
        library = new HashMap<>();
    }

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            library.remove(book);
            System.out.printf("Книга удалена " + book);
        } else {
            System.out.printf("Такой книги нет в библиотеке");
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = library.get(book);
        if (location != null) {
            System.out.printf("Книга найдена " + book + "location " + location);
        } else {
            System.out.printf("Такой книги нет в библиотеке");
        }
    }

    public void printAllBooks() {
        if (library.isEmpty()) {
            System.out.printf("Библиотека пуста");
        } else {
            for (Map.Entry<Book, String> entry : library.entrySet()) {
                System.out.printf(entry.getKey() + " - location: " + entry.getValue());
            }
        }
    }
}