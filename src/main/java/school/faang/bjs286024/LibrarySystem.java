package school.faang.bjs286024;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final Map<Book, String> books = new HashMap<>();

    public static void addBook(String title, String author, int year, String location) {
        books.put(new Book(title, author, year), location);
    }

    public static void removeBook(String title, String author, int year) {
        books.entrySet().removeIf(book -> book.getKey().getTitle().equals(title) &&
                book.getKey().getAuthor().equals(author) &&
                book.getKey().getYear() == year);
    }

    public static void findBook(String title, String author, int year) {
        for (Map.Entry<Book, String> book : books.entrySet()) {
            if (book.getKey().getTitle().equals(title) &&
                    book.getKey().getAuthor().equals(author) &&
                    book.getKey().getYear() == year) {
                System.out.println(book + " is located here:" + book.getValue());
                return;
            }
        }
        System.out.println("Book is not found!");
    }

    public static void printAllBooks() {
        for (Map.Entry<Book, String> book : books.entrySet()) {
            System.out.println(book + " is located here:" + book.getValue());
        }
    }
}
