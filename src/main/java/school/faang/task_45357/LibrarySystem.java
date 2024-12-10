package school.faang.task_45357;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    Map<Book, String> books = new HashMap<>();

    void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        this.books.put(book, location);
        System.out.println("Книга убрана на " + location);
    }

    void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            this.books.remove(book);
            System.out.println("после удаления полка содержит " + books);
        } else {
            System.out.println("такой книги нет...");
        }
    }

    void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            System.out.println("Местоположение книги: " + books.get(book));
        } else {
            System.out.println("такой книги нет...");
        }
    }

    void printAllBooks() {
        System.out.println(books);
    }

}
