package school.faang.westeroslibrary;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        books.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        books.remove(book);
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return books.getOrDefault(book, "Такой книги нет в библиотеке");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> book : books.entrySet()) {
            System.out.println("Книга " + book.getKey().getTitle() + " находится " + book.getValue());
        }
    }
}
