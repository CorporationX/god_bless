package school.faang.LibraryOfWesteros;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private HashMap<Book, String> mapBook = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        mapBook.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        mapBook.remove(new Book(title, author, year));
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (mapBook.containsKey(book)) {
            return mapBook.get(book);
        }
        return "Книга не найдена";
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : mapBook.entrySet()) {
            System.out.println("Книга: " + entry.getKey().toString() + ". Находится: " + entry.getValue());
        }
    }
}
