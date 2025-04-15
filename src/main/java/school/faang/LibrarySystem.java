package school.faang;

import java.util.HashMap;

public class LibrarySystem {
    public final HashMap<Book, String> bookMap = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        bookMap.put(new Book(title, author, year), location);
    }

    public boolean removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return bookMap.remove(book) != null;
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return bookMap.getOrDefault(book, "The book is not found.");
    }

    public void printAllBooks() {
        for (HashMap.Entry<Book, String> book : bookMap.entrySet()) {
            System.out.printf("The book: %s is located in: %s." , book.getKey(), book.getValue());
        }
    }
}
