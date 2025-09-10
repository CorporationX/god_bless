package school.faang.bjs2_86182;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;


@AllArgsConstructor
public class LibrarySystem {
    private HashMap<Book, String> library;

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
        System.out.println("Книга добавлена: " + book + ". на " + location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = library.remove(book);

        if (location != null) {
            System.out.println("Книга была удалена " + book + " с полки " + location);
        } else {
            System.out.println("Книга " + book + " не найдена.");
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = library.get(book);

        if (location != null) {
            System.out.println("Книга найдена: " + book + " на полке " + location);
        } else {
            System.out.println("Книга не найдена: " + book);
        }
    }

    public void printAllBooks() {
        System.out.println("Список всех книг:");
        for (Map.Entry<Book, String> bookEntry : library.entrySet()) {
            System.out.println(bookEntry.getKey() + " находится на " + bookEntry.getValue());
        }
    }
}
