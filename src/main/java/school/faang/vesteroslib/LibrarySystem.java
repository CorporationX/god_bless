package school.faang.vesteroslib;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    private final HashMap<Book, String> records = new HashMap<>();

    public String addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        return records.put(book, location);
    }

    public String removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        return records.remove(bookToRemove);
    }

    public String findBook(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);
        return records.get(bookToFind);
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> record : records.entrySet()) {
            Book book = record.getKey();
            System.out.printf("%s written by %s in %d is on the %s\n",
                    book.getTitle(),
                    book.getAuthor(),
                    book.getYear(),
                    record.getValue());
        }
    }
}
