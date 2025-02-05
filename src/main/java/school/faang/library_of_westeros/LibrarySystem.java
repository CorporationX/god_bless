package school.faang.library_of_westeros;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class LibrarySystem {

    private HashMap<Book, String> libraryWesteros = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Нужно указать комнату и номер полки где храниться книга");
        }

        Book book = new Book(title, author, year);
        if (libraryWesteros.containsKey(book)) {
            throw new IllegalArgumentException("Книга %s уже есть в библиотеке".formatted(book.getTitle()));
        }
        libraryWesteros.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        searchBook(book);
        libraryWesteros.remove(book);
        System.out.println("Книга успешна удалена");
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        searchBook(book);
        System.out.printf("Книга %s находится в %s", book.getTitle(), libraryWesteros.get(book));
    }

    public void printBook() {
        for (Map.Entry<Book, String> entry : libraryWesteros.entrySet()) {
            System.out.printf("Книга %s находится в %s", entry.getKey(), entry.getValue());

        }
    }

    private void searchBook(Book book) {
        if (!libraryWesteros.containsKey(book)) {
            throw new NoSuchElementException("Книги %s нет в библиотеке".formatted(book.getTitle()));
        }
    }
}
