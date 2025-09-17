package school.faang.bjs2_86260_1_1_3_1_vesteros_library;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class LibrarySystem {
    private Map<Book, String> locations = new HashMap<Book, String>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        locations.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        locations.remove(book);
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return locations.getOrDefault(book, "Книга не найдена");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : locations.entrySet()) {
            System.out.println("Книга " + entry.getKey().getTitle() + "находится в " + entry.getValue());
        }
    }

}
