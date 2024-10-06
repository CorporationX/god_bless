package faang.school.godbless.library;

import lombok.ToString;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ToString
public class MainLibrary {
    private final Map<Book, String> library = new HashMap<>();

    public Map<Book, String> getLibrary() {
        return Collections.unmodifiableMap(library);
    }

    public void addBook(Book book, String position) {
        library.put(book, position);
    }

    public void removeBook(String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    public String searchBook(String title, String author, int year) {
        return library.get(new Book(title, author, year));
    }

}
