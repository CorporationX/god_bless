package school.faang.library;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Library {
    private final Map<Book, String> bookToPlace = new HashMap<>();

    public void add(Book book, String place) {
        Objects.requireNonNull(book, "Пустую книгу положить не можем");
        if(place == null || place.isEmpty()){
            throw new IllegalArgumentException("Книга должна где-то лежать");
        }
        bookToPlace.put(book, place);
    }

    public void remove(String title, String author, int year) {
        bookToPlace.remove(new Book(title, author, year));
    }

    public String getLocation(String title, String author, int year) {
        return bookToPlace.get(new Book(title, author, year));
    }

    public void printBooks() {
        bookToPlace.forEach((book, place) -> System.out.println(book + ": " + place));
    }
}
