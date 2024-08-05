package faang.school.godbless.library_of_westeros;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> books = new HashMap<>();

        books.put(new Book("The Hobbit", "J.R.R. Tolkien", 1937), "1");
        books.put(new Book("The Fellowship of the Ring", "J.R.R. Tolkien", 1954), "2");
        books.put(new Book("The Return of the King", "J.R.R. Tolkien", 1955), "3");

        addBook(books, new Book("The Two Towers", "J.R.R. Tolkien", 1954), "3");
        System.out.println(books);

        removeBook(books, new Book("The Two Towers", "J.R.R. Tolkien", 1954));
        System.out.println(books);

        printIfoBookHerLocation(books, new Book("The Return of the King", "J.R.R. Tolkien", 1955));

        printInfoAllBooks(books);
    }

        public static void addBook(Map<Book, String> books, Book book, String shelf) {
            books.put(book, shelf);
        }

        public static void removeBook(Map<Book, String> books, Book book) {
            books.remove(book);
        }

        public static void printIfoBookHerLocation(Map<Book, String> books, Book book) {
            System.out.println("Book: " + book.getTitle() + ", location shelf: " + books.get(book));
        }

        public static void printInfoAllBooks(Map<Book, String> books) {
            for (Map.Entry<Book, String> entry : books.entrySet()) {
                Book book = entry.getKey();
                System.out.printf(
                        "Book title: %s, author: %s, year: %s, location shelf: %s\n",
                        book.getTitle(),
                        book.getAuthor(),
                        book.getYear(),
                        entry.getValue()
                );
            }
        }
}
