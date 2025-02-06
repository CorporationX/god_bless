package school.faang.library_of_westeros;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class LibrarySystem {

    private final Map<Book, String> bookLocations = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Нужно указать комнату и номер полки где храниться книга");
        }

        Book book = new Book(title, author, year);
        if (bookLocations.containsKey(book)) {
            throw new IllegalArgumentException("Книга %s уже есть в библиотеке".formatted(book.getTitle()));
        }
        bookLocations.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        searchBook(book);
        bookLocations.remove(book);
        System.out.println("Книга успешна удалена");
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        searchBook(book);
        return String.format("Книга %s находится в %s", book.getTitle(), bookLocations.get(book));
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : bookLocations.entrySet()) {
            System.out.printf("Книга %s находится в %s\n", entry.getKey(), entry.getValue());

        }
    }

    private void searchBook(Book book) {
        if (!bookLocations.containsKey(book)) {
            throw new NoSuchElementException("Книги %s нет в библиотеке".formatted(book.getTitle()));
        }
    }
}