package school.faang.task45305.service;

import school.faang.task45305.model.Book;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    private final Map<Book, String> booksLocations = new HashMap<>();

    public LibrarySystem(Map<Book, String> books) {
        this.booksLocations.putAll(books);
    }

    public void addBook(String title, String author, int year, String location) {
        booksLocations.put(new Book(title, author, year), location);
    }

    public boolean removeBook(String title, String author, int year) {
        return booksLocations.remove(new Book(title, author, year)) != null;
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        StringBuilder bookLocation;
        bookLocation = new StringBuilder();
        bookLocation.append("Книга ")
                .append(book)
                .append(" находится тут: ")
                .append(booksLocations.getOrDefault(new Book(title, author, year), "Книга не найдена!"));

        return bookLocation.toString();
    }

    public void printAllBooks() {
        System.out.println("All books:");
        for (Map.Entry<Book, String> entry : booksLocations.entrySet()) {
            System.out.println("Книга " + entry.getKey() + " находится на полке : " + entry.getValue());
        }

    }

}
