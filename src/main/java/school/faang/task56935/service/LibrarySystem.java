package school.faang.task56935.service;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    Map<Book, String> placeBook = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        placeBook.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        placeBook.remove(new Book(title, author, year));
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
