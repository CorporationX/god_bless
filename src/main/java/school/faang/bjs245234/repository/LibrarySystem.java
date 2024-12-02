package school.faang.bjs245234.repository;

import lombok.AllArgsConstructor;
import lombok.ToString;
import school.faang.bjs245234.model.Book;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
@ToString
public class LibrarySystem {
    private Map<Book, String> library;

    public void addBook(String title, String author, int year, String location) {
        this.library.put(new Book(title, author, year), Objects.requireNonNull(location));
    }

    public void removeBook(String title, String author, int year) {
        this.library.entrySet().removeIf(entry -> entry.getKey().equals(new Book(title, author, year)));
    }

    public String findLocationBook(String title, String author, int year) {
        String location = this.library.entrySet().parallelStream().filter(entry ->
                        entry.getKey().equals(new Book(title, author, year)))
                .findFirst().orElse(new AbstractMap.SimpleEntry<>(null, null)).getValue();
        if (location == null) {
            System.out.println("Book don't found");
        }
        return location;
    }

    public void printAllBooks() {
        System.out.println(this);
    }
}
