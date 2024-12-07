package derschrank.task08.bjstwo_45248;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> booksByLocationMap;

    LibrarySystem(Map<Book, String> map) {
        booksByLocationMap = map;
    }

    LibrarySystem() {
        this(new HashMap<>());
    }

    public void addBook(String title, String author, int year, String location) {
        addBook(new Book(title, author, year), location);
    }

    public void addBook(Book book, String location) {
        //Не согласен с тем что книга хранится на прямую в мапе, получается у нас одна книга может быть такая
        booksByLocationMap.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        removeBook(new Book(title, author, year));
    }

    public void removeBook(Book book) {
        booksByLocationMap.remove(book);
    }

    public String findBook(String title, String author, int year) {
        return findBook(new Book(title, author, year));
    }

    public String findBook(Book book) {
        return booksByLocationMap.get(book);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Library has books:\n");
        for (Map.Entry<Book, String> bookAndLocation : booksByLocationMap.entrySet()) {
            result.append(bookAndLocation.getKey());
            result.append(" is located at: ");
            result.append(bookAndLocation.getValue());
            result.append("\n");
        }
        return result.toString();
    }

    public void printAllBooks() {
        System.out.println(this);
    }

}
