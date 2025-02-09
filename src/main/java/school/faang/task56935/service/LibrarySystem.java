package school.faang.task56935.service;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class LibrarySystem {
    private final Map<Book, String> placeBook = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        if (placeBook.containsKey(new Book(title, author, year))) {
            System.out.println("Такая книга уже есть\n");
        } else {
            placeBook.put(new Book(title, author, year), location);
        }
    }

    public void removeBook(String title, String author, int year) {
        if (placeBook.containsKey(new Book(title, author, year))) {
            placeBook.remove(new Book(title, author, year));
        } else {
            System.out.println("Такой книги нет\n");
        }
    }

    public String findBook(String title, String author, int year) {
        Book searchBook = new Book(title, author, year);
        return placeBook.getOrDefault(searchBook, "Книга не найдена");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : placeBook.entrySet()) {
            System.out.print("название книги: \"" + entry.getKey().getTitle() +
                    "\" \nавтор: " + entry.getKey().getAuthor() +
                    " \nгод: " + entry.getKey().getYear() + "\nместо: " +
                    entry.getValue() + "\n===============================\n");
        }
    }
}
