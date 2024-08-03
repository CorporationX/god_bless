package faang.school.godbless.BJS2_19234;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;

@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class Book {

    private String title;
    private String author;
    private int year;

    public static void addLocationBook(Map<Book, String> locationBooks, Book book, String location) {
        locationBooks.put(book, location);
    }

    public static void removeLocationBook(Map<Book, String> locationBooks, Book book) {
        locationBooks.remove(book);
    }

    public static String getLocationBook(Map<Book, String> locationBooks, Book book) {
        return locationBooks.get(book);
    }

    public static void printLocationBooks(Map<Book, String> locationBooks) {
        for (Map.Entry<Book, String> entry : locationBooks.entrySet()) {
            System.out.printf("%s = %s%n", entry.getKey(), entry.getValue());
        }
    }
}
