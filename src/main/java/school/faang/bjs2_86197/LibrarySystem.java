package school.faang.bjs2_86197;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    public final Map<Book, String> bookLocations = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        bookLocations.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        bookLocations.remove(new Book(title, author, year));
    }

    public void findBook(String title, String author, int year) {
        String location = bookLocations.getOrDefault(new Book(title, author, year), "Книга не найдена");
        System.out.println(location);
    }

    public void printAllBooks() {
        if (bookLocations.isEmpty()) {
            System.out.println("Библиотека пуста");
        }

        for (Map.Entry<Book, String> entry : bookLocations.entrySet()) {
            Book key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " → " + value);
        }
    }
}
