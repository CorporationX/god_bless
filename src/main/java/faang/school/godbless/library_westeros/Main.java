package faang.school.godbless.library_westeros;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> books = new HashMap<>();

        Book crimeAndPunishment = new Book("Crime and punishment", "F.Dostoevskii", 1866);
        Book prideAndPrejudice = new Book("Pride and Prejudice", "D. Ostin", 1813);
        Book transformation = new Book("Transformation", "F.Kafka", 1912);
        Book pictureOfDorianGray = new Book("The Picture of Dorian Gray", "O. Wilde", 1890);

        books.put(crimeAndPunishment, "C-P");
        books.put(prideAndPrejudice, "P-P");
        books.put(pictureOfDorianGray, "P-D");

        showInfo(books);
        addBook(books, transformation, "Y");
        showInfo(books);
        System.out.println("________RAZDELITEL'__________");
        findsBooksByTittleBook(books, "The Picture of Dorian Gray");
        removeBooksByTitleAutorYear(books, "Crime and punishment", "F.Dostoevskii", 1866);
        showInfo(books);
    }

    public static void addBook(Map<Book, String> books, Book book, String tittle) {
        if (book == null || tittle == null || tittle.isBlank()) {
            throw new IllegalArgumentException("fields cannot be empty");
        }
        if (books.putIfAbsent(book, tittle) != null) {
            System.out.println("The book already exists in the map");
        } else {
            System.out.println("Book successfully added");
        }
    }

    public static void removeBooksByTitleAutorYear(Map<Book, String> books, String title, String autor, int year) {
        if (title != null && autor != null && year != 0) {
            Book book = new Book(title, autor, year);
            if (books.containsKey(book)) {
                books.remove(book);
                System.out.println("Book delete");
            } else {
                System.out.println("The book is not found");
            }
        }
    }


    public static List<Book> findsBooksByTittleBook(Map<Book, String> books, String titleBook) {
        List<Book> foundTheBooks = new ArrayList<>();
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            if (entry.getKey().getTitle().equalsIgnoreCase(titleBook)) {
                foundTheBooks.add(entry.getKey());
            }
        }
        if (foundTheBooks.isEmpty()) {
            throw new IllegalArgumentException("Book id not found");
        }
        return foundTheBooks;
    }

    public static void showInfo(Map<Book, String> books) {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey() + " находится на полке " + entry.getValue());
        }
    }
}

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
class Book {
    private String title;
    private String autor;
    private int year;
}
