package school.faang.bjs2_68666;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LibrarySystem {
    private final Map<Book, String> booksPlace = new HashMap<>();
    private static final String BOOK_NOT_FOUND_MSG = "Book not found!";

    public void addBook(String title, String author, int year, String location) {
        this.booksPlace.put(new Book(title, author, year), location);
    }

    public String findBook(String title, String author, int year) {
        String location;
        Book book = new Book(title, author, year);
        location = this.booksPlace.getOrDefault(book, BOOK_NOT_FOUND_MSG);
        return location;
    }
    
    public void removeBook(String title, String author, int year) {
        if (!Objects.equals(findBook(title, author, year), BOOK_NOT_FOUND_MSG)) {
            this.booksPlace.remove(new Book(title, author, year));
        }
    }
    
    public List<String> printAllBooks() {
        List<String> bookList = new ArrayList<>();
        for (Map.Entry<Book, String> entry : this.booksPlace.entrySet()) {
            bookList.add(entry.getKey().toString() + " on " + entry.getValue());
        }
        return bookList;
    }
}
