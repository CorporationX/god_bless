package faang.school.godbless.BJS2_19289;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> booksShelf = new HashMap<>();

    public static void main(String[] args) {
        booksShelf.put(new Book("Got", "Martin", 2000), "14");
        booksShelf.put(new Book("Childhood", "Pupsov", 1983), "24");
        booksShelf.put(new Book("Terror", "Someone", 2000), "14");
        booksShelf.put(new Book("Hex", "", 2000), "14");

        add("One more title", "Boomer", 2020, "69");
        removeBook("Terror", "Someone", 2000);
        findShelf("Hex", "", 2000);
        findAllBooks();
    }

    public static void add(String title, String author, int year, String shelf) {
        booksShelf.put(new Book(title, author, year), shelf);
    }

    public static void removeBook(String title, String author, int year) {
        booksShelf.remove(new Book(title, author, year));
    }

    public static void findShelf(String title, String author, int year) {
        System.out.println(booksShelf.get(new Book(title, author, year)));
    }

    public static void findAllBooks() {
        booksShelf.forEach((book, shelf) -> System.out.println(String.format("Book: %s, shelf: %s", book, shelf)));
    }
}
