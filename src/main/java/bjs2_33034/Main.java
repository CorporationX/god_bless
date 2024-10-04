package bjs2_33034;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        addBook(new Book("Book1", "Author1", 1950), "shelf1");
        addBook(new Book("Book2", "Author2", 1977), "shelf2");
        addBook(new Book("Book3", "Author3", 1956), "shelf3");
        addBook(new Book("Book4", "Author4", 1995), "shelf4");

        deleteBook("Book3", "Author3", 1956);

        String shelf2 = searchBook("Book2", "Author2", 1977);
        System.out.println(shelf2);

        printAllBooks();
    }

    public static void addBook(Book book, String shelf) {
        library.put(book, shelf);
    }

    public static void deleteBook(String title, String author, Integer year) {
        library.remove(new Book(title, author, year));
    }

    public static String searchBook(String title, String author, Integer year) {
        return library.get(new Book(title, author, year));
    }

    public static void printAllBooks() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }
    }
}
