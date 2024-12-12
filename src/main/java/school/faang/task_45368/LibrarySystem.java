package school.faang.task_45368;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class LibrarySystem {
    private final Map<Book, String> books;

    public LibrarySystem(Map<Book, String> initialBooks) {
        this.books = new HashMap<>(initialBooks);
    }

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            System.out.printf("Книга '%s' уже существует в библиотеке на месте: %s%n", title, books.get(book));
        } else {
            books.put(book, location);
            System.out.printf("Книга '%s' добавлена в библиотеку на место: %s%n", title, location);
        }
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            books.remove(book);
            System.out.printf("Книга '%s' удалена из библиотеки.%n", title);
        } else {
            System.out.printf("Книга '%s' не найдена в библиотеке.%n", title);
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = books.get(book);
        if (books.containsKey(book)) {
            System.out.printf("Книга с названием: '%s' и найдена в: %s%n", title, location);
        } else {
            System.out.printf("Книга: '%s' не найдена%n", book.getTitle());
        }
    }

    public void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Библиотека пуста.%n");
        } else {
            System.out.println("--Список всех книг в библиотеке:");
            books.forEach((book, location) ->
                    System.out.printf("-Книга с названием: '%s' находится в: %s%n", book.getTitle(), location));
        }
    }
}
