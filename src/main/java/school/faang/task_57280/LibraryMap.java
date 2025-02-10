package school.faang.task_57280;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Data
public class LibraryMap {
    private Map<Book, String> libraryMap = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        libraryMap.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        libraryMap.remove(new Book(title, author, year));
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String result = libraryMap.get(book);
        System.out.println(Objects.requireNonNullElse(result,
                "There is no book like this!"));
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : libraryMap.entrySet()) {
            System.out.println("Book: " + entry.getKey() + ", Placement: " + entry.getValue());
        }
    }
}
