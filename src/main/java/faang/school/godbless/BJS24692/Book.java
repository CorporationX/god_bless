package faang.school.godbless.BJS24692;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class Book {

    private String title;
    private String author;
    private int year;

    public static void addBook(Map<Book, String> library, Book book, String location) {
        library.put(book, location);
    }

    public static void removeBook(Map<Book, String> library, Book book) {
        library.remove(book);
    }

    public static void findBook(Map<Book, String> library, Book book) {
        String location = library.get(book);
        System.out.println("Поиск книги..." + book);
        if (location != null) {
            System.out.println("Книга найдена в местонахождении: " + location);
        } else {
            System.out.println("Книга не найдена в библиотеке.");
        }
    }

    public static void printBooks(Map<Book, String> library) {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println("Книга: " + entry.getKey() + ", Местонахождение: " + entry.getValue());
        }
    }
}
