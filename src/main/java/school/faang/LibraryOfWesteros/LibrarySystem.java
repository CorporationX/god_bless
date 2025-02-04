package school.faang.LibraryOfWesteros;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> BOOKS = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        BOOKS.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        BOOKS.remove(book);

    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);

        if (BOOKS.containsKey(book)) {
            System.out.printf("Книжка %s находится на %s\n", book, BOOKS.get(book));

        } else {
            System.out.println("Книги нет в библиотеке");
        }

    }

    public void printAllBooks() {
        System.out.println(BOOKS);
    }
}

