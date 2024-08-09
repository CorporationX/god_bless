package faang.school.godbless.library_of_westeros;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {
        addBook(new Book("The Return of the King", "J.R.R. Tolkien", 1955), "1");
        addBook(new Book("The Two Towers", "J.R.R. Tolkien", 1954), "3");
        System.out.println(books);

        removeBook(new Book("The Two Towers", "J.R.R. Tolkien", 1954));
        System.out.println(books);

        printIfoBookHerLocation(new Book("The Return of the King", "J.R.R. Tolkien", 1955));

        printInfoAllBooks();
    }

        public static void addBook(Book book, String shelf) {
            books.put(book, shelf);
        }

        public static void removeBook(Book book) {
            books.remove(book);
        }

        public static void printIfoBookHerLocation(Book book) {
            System.out.println(books.getOrDefault(book, "Not found"));
        }

        public static void printInfoAllBooks() {
            for (Map.Entry<Book, String> entry : books.entrySet()) {
                System.out.println(entry.getKey());
            }
        }
}
