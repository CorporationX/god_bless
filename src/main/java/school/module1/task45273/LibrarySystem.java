package school.module1.task45273;

import java.util.Map;

import static school.module1.task45273.Main.bookLocation;

public class LibrarySystem {

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        bookLocation.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        bookLocation.remove(book);
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        System.out.println(bookLocation.getOrDefault(book, "Нет книги"));
        return bookLocation.getOrDefault(book, "Нет книги");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : bookLocation.entrySet()) {
            System.out.println(entry.getKey() + " - местоположение " + entry.getValue());
        }
    }
}
