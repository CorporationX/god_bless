package school.faang.sprint1.bjs_45360;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Main {
    private static Map<Book, String> books = addBooks();

    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem(books);

        // тестирование метода addBook
        librarySystem.addBook("Ревьюер", "Улыбнись)", 2024, ":D");

        // тестирование метода removeBook
        librarySystem.removeBook("1984", "J.Orwell", 1949);

        // тестирование метода findBook
        librarySystem.findBook("Fahrenheit 451", "Ray Bradbury", 1953);

        // тестирование метода printAllBooks
        librarySystem.printAllBooks();
    }

    private static Map<Book, String> addBooks() {
        Map<Book, String> books = new HashMap<>();

        String[][] booksData = {
                {"1984", "J.Orwell", "1949", "A01"},
                {"Fahrenheit 451", "Ray Bradbury", "1953", "B05"},
                {"Anna Karenina", "Lev Tolstoy", "1873", "C08"}
        };

        for (String[] book : booksData) {
            String title = book[0];
            String author = book[1];
            int year = Integer.parseInt(book[2]);
            String location = book[3];

            books.put(new Book(title, author, year), location);
        }

        return books;
    }
}
