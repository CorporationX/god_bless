package faang.school.godbless;

import faang.school.godbless.Book.Book;
import java.util.*;

public class Application {
    private Map<Book, String> books = new HashMap<>();

    public void addBook(Book book, String location) {
        books.put(book, location);
    }

    public boolean removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        return books.remove(bookToRemove) != null;
    }

    public String findBook(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);
        return books.get(bookToFind);
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey() + " - Location: " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        Application app = new Application();

        app.addBook(new Book("1984", "George Orwell", 1949), "Shelf A1");
        app.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 1960), "Shelf B2");
        app.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925), "Shelf C3");

        String location = app.findBook("1984", "George Orwell", 1949);
        System.out.println("Location of '1984': " + location);

        System.out.println("All books in the library:");
        app.printAllBooks();

        boolean removed = app.removeBook("To Kill a Mockingbird", "Harper Lee", 1960);
        System.out.println("Book removed: " + removed);

        System.out.println("Updated list of books:");
        app.printAllBooks();
    }
}