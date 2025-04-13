package BJS2_69795;

import java.util.Objects;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class LibrarySystem {
    private final Map<Book, String> placeBook = new HashMap<>();
    private static final String BOOK_NOT_FOUND = "Book nort found!";

    public void addBook(String title, String author, int year, String location) {
        this.placeBook.put(new Book(title, author, year), location);
    }

    public String findBook(String title, String author, int year) {
        String location;
        Book book = new Book(title, author, year);
        location = this.placeBook.getOrDefault(book, BOOK_NOT_FOUND);
        return location;
    }

    public void removeBook(String title, String author, int year) {
        if (!Objects.equals(findBook(title, author, year), BOOK_NOT_FOUND)) {
            this.placeBook.remove(new Book(title, author, year));
        }
    }

    public List<String> printAllBooks() {
        List<String> listBook = new ArrayList<>();
        for (Map.Entry<Book, String> entry : this.placeBook.entrySet()) {
            listBook.add(entry.getKey().toString() + " в " + entry.getValue());
        }
        return listBook;
    }
}

