package BJS2_8268;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static final Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {


        books.put(new Book("Forty Years of Pop", "Steve Flinders", 2003), "A Table 1");
        books.put(new Book("A Dubious Legacy", "Wesley Mary", 2014), "A Table 2");

        addBooks(new Book("A Dubious Legacy2", "Wesley Mary2", 2014), "A Table 3");

        deleteBook(new Book("A Dubious Legacy2", "Wesley Mary2", 2014));

        showBooks(books);
        searchBook(books, new Book("A Dubious Legacy", "Wesley Mary", 2014));
    }

    public static void addBooks(Book book, String table) {
        books.put(book, table);
    }

    public static void deleteBook(Book book) {
        books.remove(new Book(book.title(), book.author(), book.year()));
    }

    public static void searchBook(Map<Book, String> oneBook, Book book) {
        System.out.println(oneBook.get(new Book(book.title(), book.author(), book.year())));
    }

    public static void showBooks(Map<Book, String> books) {
        for (Map.Entry<Book, String> book : books.entrySet()) {
            System.out.println(book.getKey() + " " + book.getValue());
        }
    }
}
