package school.faang.bjs245335;

import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> books;

    public LibrarySystem(Map<Book, String> books) {
        this.books = books;
    }

    public void addBook(String title, String author, int year, String location) {
        books.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        books.remove(new Book(title, author, year));
    }

    public String findBook(String title, String author, int year) {
        return books.get(new Book(title, author, year));
    }

    public void printAllBooks() {
        System.out.println(books.toString());
    }
}
