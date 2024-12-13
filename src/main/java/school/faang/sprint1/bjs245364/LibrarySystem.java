package school.faang.sprint1.bjs245364;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@EqualsAndHashCode
public class LibrarySystem {
    private Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location, Map<Book, String> books) {
        Book book = new Book(title, author, year);
        books.putIfAbsent(book, location);
        System.out.println("Книга '" + book.getTitle() + "' добавлена на " + location + "-ю полку.");
    }

    public void removeBook(String title, String author, int year, Map<Book, String> books) {
        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            books.remove(book);
            System.out.println("Книга '" + book.getTitle() + "' удалена.");
        } else {
            System.out.println("Такой книги нет в библиотеке!");
        }
    }

    public void findBook(String title, String author, int year, Map<Book, String> books) {
        Book book = new Book(title, author, year);
        if (books.get(book) != null) {
            System.out.println("Книга '" + book.getTitle() + "' лежит на " + books.get(book) + "-й полке.");
        } else {
            System.out.println("Книга '" + book.getTitle() + " не найдена!");
        }
    }

    public void printAllBooks(Map<Book, String> books) {
        System.out.println("\nСписок всех книг в библиотеке:");
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey().toString() + "лежит на " + entry.getValue() + "-й полке.");
        }
    }
}
