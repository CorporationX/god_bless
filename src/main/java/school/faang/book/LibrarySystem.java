package school.faang.book;


import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    HashMap<String, Book> bookHashMap = new HashMap<>();

    public HashMap<String, Book> addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        bookHashMap.put(location, book);
        return bookHashMap;
    }

    public void removeBook(String title, String author, int year) {
        bookHashMap.entrySet().removeIf(entry -> entry.getValue().getTitle().equals(title)
                && entry.getValue().getAuthor().equals(author)
                && entry.getValue().getYear() == year);
        System.out.println(bookHashMap);
    }

    public Book findBook(String title, String author, int year) {
        return bookHashMap.values()
                .stream()
                .filter(book -> book.getTitle().equals(title))
                .filter(book -> book.getAuthor().equals(author))
                .filter(book -> book.getYear() == year)
                .findFirst()
                .orElse(null);
    }

    public void printAllBooks() {
        for (Map.Entry<String, Book> entry : bookHashMap.entrySet()) {
            System.out.println(entry);
        }
    }
}
