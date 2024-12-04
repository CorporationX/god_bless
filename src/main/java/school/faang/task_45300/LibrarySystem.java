package school.faang.task_45300;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class LibrarySystem {
    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        HashMap<Book, String> booksMap = new HashMap<>();

        booksMap.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        HashMap<Book, String> booksMap = new HashMap<>();

        booksMap.remove(book);
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        HashMap<Book, String> booksMap = new HashMap<>();

        if (booksMap.containsKey(book)) {
            return booksMap.get(book);
        } else {
            return "Книга не найдена!";
        }
    }

    public void printAllBooks() {
        HashMap<Book, String> booksMap = new HashMap<>();

        for (Map.Entry<Book, String> entry : booksMap.entrySet()) {
            Book key = entry.getKey();
            String value = entry.getValue();

            System.out.println("Book: " + key + " , location: " + value);
        }
    }
}
