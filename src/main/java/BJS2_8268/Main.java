package BJS2_8268;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> books = new HashMap<>();

        books.put(new Book("Forty Years of Pop", "Steve Flinders", 2003), "A Table 1");
        books.put(new Book("A Dubious Legacy", "Wesley Mary", 2014), "A Table 2");

        Book bookNewABook = new Book("Slime - The Wonderful World of Mucus", "Kenna Bourke", 1990);
        String table = "A Table 3";

        books.putAll(addBooks(bookNewABook, table));

        deleteBook(books, bookNewABook);

        books.putAll(addBooks(bookNewABook, table));
        showBooks(books);

        searchBook(books, bookNewABook);
    }

    public static Map<Book, String> addBooks(Book book, String table) {
        Map<Book, String> addBook = new HashMap<>();
        addBook.put(book, table);
        return addBook;
    }

    public static void deleteBook(Map<Book, String> oneBook, Book book) {
        oneBook.remove(new Book(book.getTitle(), book.getAuthor(), book.getYear()));
    }

    public static void searchBook(Map<Book, String> oneBook, Book book) {
        System.out.println(oneBook.get(new Book(book.getTitle(), book.getAuthor(), book.getYear())));
    }

    public static void showBooks(Map<Book, String> books) {
        for (Map.Entry<Book, String> book : books.entrySet()) {
            System.out.println(book.getKey() + " " + book.getValue());
        }
    }
}
