package school.faang;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    private final HashMap<Book, String> bookLocation = new HashMap<>();
    Book book;

    public void addBook(String title, String author, int year, String location) {
        book = new Book(title, author, year);
        try {
            bookLocation.put(book, location);
            System.out.println("Book added: " + book);
        } catch (NullPointerException e) {
            System.out.println("Book is empty");
        }
    }

    public void removeBook(String title, String author, int year) {
        book.setTitle(title);
        book.setAuthor(author);
        book.setYear(year);
        if (bookLocation.containsKey(book)) {
            System.out.println("Book was delete? " + bookLocation.get(book));
            System.out.println("Book deleted: " + book);
            bookLocation.remove(book);
        } else {
            System.out.println("Book not found");
        }
    }

    public void findBook(String title, String author, int year) {
        book.setTitle(title);
        book.setAuthor(author);
        book.setYear(year);
        System.out.println(bookLocation.get(book));
        System.out.println(bookLocation.getOrDefault(book, "This book does not exist"));

    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : bookLocation.entrySet()) {
            System.out.println("| Book | : " + entry.getKey() + " | Location |: " + entry.getValue() + "\n");
        }
    }
}
