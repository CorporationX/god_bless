package school.faang.bjs2_86123;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> books = new HashMap<>();

    public LibrarySystem() {

    }

    public void addBook(String title, String author, int year, String location) {
        books.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        books.remove(new Book(title, author, year));
    }

    public void findBook(String title, String author, int year) {
        String location = books.get(new Book(title, author, year));
        if (location != null) {
            System.out.println("Местонахождение: " + location);
        } else {
            System.out.println("Книга не найдена");
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println("Местонахождение: " + entry.getValue());
            System.out.println();
        }
    }
}
