package school.faang.libraryofwesteros;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> mapBook = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        this.mapBook.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        this.mapBook.remove(new Book(title, author, year));
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (this.mapBook.containsKey(book)) {
            return this.mapBook.get(book);
        }
        return "Книга не найдена";
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : this.mapBook.entrySet()) {
            System.out.println("Книга: " + entry.getKey().toString() + ". Находится: " + entry.getValue());
        }
    }
}
