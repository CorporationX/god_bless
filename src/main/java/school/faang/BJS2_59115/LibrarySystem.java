package school.faang.BJS2_59115;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;

@Getter
@ToString
public class LibrarySystem {
    private static HashMap<Book, String> books = new HashMap<>();

    public static void addBook(String title, String author, int year, String location) {
        validateParams(title, author, year, location);
        books.put(new Book(title, author, year), location);
    }

    private static void validateParams(String title, String author, int year, String location) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Автор не может быть пустым");
        }
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Локация не может быть пустой");
        }
        if (!(year > 0 && year <= 2025)) {
            throw new IllegalArgumentException("Некорректный год");
        }
    }

    public static boolean removeBook(String title, String author, int year) {
        int n = books.size();
        books.remove(new Book(title, author, year));

        if (books.size() == n - 1) {
            return true;
        }

        return false;
    }

    public static String findBook(String title, String author, int year) {
        Book bookKey = new Book(title, author, year);
        if (books.containsKey(bookKey)) {
            return books.get(bookKey);
        }

        return "Book not found";
    }

    public static void printAllBooks() {
        books.forEach((k, v) -> System.out.println(k + " " + v));
    }

}
