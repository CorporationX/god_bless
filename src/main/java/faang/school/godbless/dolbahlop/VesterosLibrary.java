package faang.school.godbless.dolbahlop;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VesterosLibrary {
    private Map<Book, String> bookStringMap;

    public VesterosLibrary(Map<Book, String> bookStringMap) {
        this.bookStringMap = bookStringMap;
    }

    public void addNewBook(Book book, String location) {
        bookStringMap.put(book, location);
    }

    public void deleteBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        bookStringMap.remove(book);
    }

    public String findBook(String title, String author, int year) {
        return bookStringMap.get(new Book(title, author, year));
    }

    public List<String> findAllBooks() {
        return bookStringMap.entrySet().stream()
                .map(entry -> entry.getKey() + " Location: " + entry.getValue())
                .collect(Collectors.toList());
    }
}
