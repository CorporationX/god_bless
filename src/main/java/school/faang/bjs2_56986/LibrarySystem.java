package school.faang.bjs2_56986;

import java.util.Map;

public class LibrarySystem {


    public void addBook(String title, String author, int year, String location, Map<Book, String> library) {
        if (title == null || author == null || location == null) {
            throw new IllegalArgumentException("Title, author, and location must not be null");
        }
        Book book = new Book(title, author, year);
        library.put(book, location);
    }

    public void removeBook(String title, String author, int year, Map<Book, String> library) {
        Book book = new Book(title, author, year);
        library.remove(book);
    }

    public void findBook(String title, String author, int year, Map<Book, String> library) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            System.out.printf("Found book: %s%n", library.get(book));
        } else {
            System.out.printf("Book %s not found%n", book);
        }
    }

    public void printAllBooks(Map<Book, String> library) {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.printf("The book: %s is on: %s\n", entry.getKey(), entry.getValue());
        }
    }

}
