package school.faang.library.BJS2_69795;

import java.util.Objects;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class LibrarySystem {
    private final Map<Book, String> placeBook = new HashMap<>();
    private static final String BOOK_NOT_FOUND = "Book nort found!";

    public void addBook(String title, String author, int year, String location) {
        placeBook.put(new Book(title, author, year), location);
    }

    public String findBook(String title, String author, int year) {
        return placeBook.get(new Book(title, author, year));
    }

    public void removeBook(String title, String author, int year) {
        if (!Objects.equals(findBook(title, author, year), null)) {
            placeBook.remove(new Book(title, author, year));
        }
    }

    public List<String> printAllBooks() {
        List<String> listBook = new ArrayList<>();
        for (Map.Entry<Book, String> entry : this.placeBook.entrySet()) {
            listBook.add("%s в %s".formatted(entry.getKey().toString(), entry.getValue()));
        }
        return listBook;
    }
}
