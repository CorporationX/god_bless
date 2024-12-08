package school.faang.sprint_1.task_bjs45348;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book newBook = new Book(title, author, year);
        library.put(newBook, location);
        System.out.println("Книга с название " + title + "находится " + location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        library.remove(book);
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = library.get(book);
        if (location == null) {
            return "Книга не найдена";
        }

        return location;
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println("Ключ: " + entry.getKey() + ", Значение: " + entry.getValue());
        }
    }
}
