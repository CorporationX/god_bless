package school.faang.bjs2_86142;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    Map<Book, String> booksAndLocation = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        booksAndLocation.put(book, location);
        System.out.println(String.format("Добавлена новая книга: %s", book.getTitle()));
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String delete = booksAndLocation.remove(book);
        if (delete == null) {
            System.out.println("Такой книги не существует");
        } else {
            System.out.println(String.format("Удалена книга: %s, она находилась в %s", book.getTitle(), delete));
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = booksAndLocation.get(book);
        if (location == null) {
            System.out.println(String.format("Книга  %s не найдена", book.getTitle()));
        } else {
            System.out.println(String.format("Книга %s найдена, ее местоположение %s", book.getTitle(), location));
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : booksAndLocation.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }
}
