package faang.school.godbless.library;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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

    public void printLibrary() {
        var sb = new StringBuilder();
        for(var book : library.entrySet()) {
            sb.append(String.format("%s | %s - %s - %s%n", book.getValue(), book.getKey().title(),
                    book.getKey().author(), book.getKey().year()));
        }
        System.out.println(sb);
    }

}
