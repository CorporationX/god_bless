package school.faang.vesteroslibrary;

import java.util.HashMap;

public class LibrarySystem {
    HashMap<Book, String> bookMap = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        bookMap.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        bookMap.remove(new Book(title, author, year));
    }

    public String findBook(String title, String author, int year) {
        return bookMap.get(new Book(title, author, year));
    }

    public void printAllBooks() {
        System.out.println(bookMap.keySet());
    }
}
