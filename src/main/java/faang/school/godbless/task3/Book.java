package faang.school.godbless.task3;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class Book {
    private String title;
    private String autor;
    private int year;

    public static void addBook(Map<Book, String> books, Book book, String strNumber) {
        if (book == null || strNumber == null || strNumber.isBlank()) {
            throw new IllegalArgumentException("fields cannot be empty");
        }
        if (books.putIfAbsent(book, strNumber) != null) {
            System.out.println("The book already exists in the map");
        } else {
            System.out.println("Book successfully added");
        }
    }

    public static void removeBook(Map<Book, String> books, String title, String autor, int year) {
        if (books == null) {
            throw new IllegalArgumentException("Empty map");
        }
        if (title != null && autor != null && year != 0) {
            Book book = new Book(title, autor, year);
            if (books.containsKey(book)) {
                books.remove(book);
                System.out.println("Book delete");
            } else {
                throw new IllegalArgumentException("The book is not found");
            }
        }
    }

    // Все что написано выше делал до созвона  -_-
    public static String findBook(Map<Book, String> books, String strNumber) {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            if (entry.getKey().getAutor().equalsIgnoreCase(strNumber)) {
                System.out.println(entry.getKey().toString());
            }
            if (entry.getKey().getTitle().equalsIgnoreCase(strNumber)) {
                System.out.println(entry.getKey().toString());
            }
        }
        return "Book is not find";
    }

    public static String findBook(Map<Book, String> books, int year) {    //перегруженый метод на поиск по (int) году книги
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            if (entry.getKey().getYear() == (year)) {
                System.out.println(entry.getKey().toString());
            }
        }
        return "Book is not find";
    }

    public static void showInfo(Map<Book, String> books) {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey() + " находится на полке " + entry.getValue());
        }
    }
}