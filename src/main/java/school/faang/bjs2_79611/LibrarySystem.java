package school.faang.bjs2_79611;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> bookLocations = new HashMap<>();
    private Map<String, List<Book>> booksByLocations = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        bookLocations.put(book, location);
        booksByLocations.computeIfAbsent(location, (target) -> new ArrayList<>()).add(book);
    }

    public void removeBook(String title, String author, int year) {
        bookLocations.remove(new Book(title, author, year));
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = bookLocations.get(book);
        if (location == null) {
            System.out.println(book + " is not founded");
        } else {
            System.out.println(book + " is located at " + location);
        }
    }

    public void printAllBooks() {
        for (var entrySet : booksByLocations.entrySet()) {
            System.out.println(entrySet.getKey());
            entrySet.getValue().forEach(System.out::println);
        }
    }
}
