package school.faang.libraryw;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> locationBook = new HashMap<Book, String>();

    public void addBook(String title, String author, int year, String location) {
        checkArguments(title, author, year);
        if (location == null || location.isEmpty()) {
            throw new NullPointerException("Местоположение книги не может быть пустым.");
        }
        locationBook.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        checkArguments(title, author, year);
        locationBook.remove(new Book(title, author, year));
    }

    public String findBook(String title, String author, int year) {
        checkArguments(title, author, year);
        var key = new Book(title, author, year);
        if (locationBook.containsKey(key)) {
            return locationBook.get(key);
        } else {
            return "Данной книги нет в библиотеке";
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : locationBook.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void checkArguments(String title, String author, int year) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Имя автора не может быть пустым");
        }
        if (year <= 0) {
            throw new IllegalArgumentException("Год должен быть больше 0");
        }
    }
}