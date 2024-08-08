package faang.school.godbless.westeroslibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private final Map<Book, String> library = new HashMap<>();

    public Main() {
        library.put(new Book("title1", "author1", "2001"), "shelf1");
        library.put(new Book("title2", "author2", "2002"), "shelf2");
        library.put(new Book("title3", "author3", "2003"), "shelf3");
    }

    public void addBook(Book book, String place) {
        library.put(book, place);
    }

    public void delBook(String author, String title, String year) {
        library.remove(new Book(author, title, year));
    }

    public String getPlace(String author, String title, String year) {
        return library.get(new Book(author, title, year));
    }

    public List<String> getAllBooks() {
        List<String> result = new ArrayList<>();

        for (Map.Entry<Book, String> entry : library.entrySet()) {
            result.add("title: " + entry.getKey() + ", place: " + entry.getValue());
        }

        return result;
    }
}
