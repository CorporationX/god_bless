package faang.school.godbless.hashmap.library;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static java.util.Optional.ofNullable;

public class Main {
    public static Map<Book, String> library = new HashMap<>(Map.of(
            new Book("1984", "George Orwell", 1949), "4CD",
            new Book("To Kill a Mockingbird", "Harper Lee", 1960), "34AB",
            new Book("Pride and Prejudice", "Jane Austen", 1813), "18FG"
    ));

    public static String addBook(Book book, String position) {
        return library.put(book, position);
    }

    public static String deleteBook(String bookTitle, String bookAuthor, int publicationYear) {
        var book = new Book(bookTitle, bookAuthor, publicationYear);

        return ofNullable(library.remove(book))
                .orElseThrow(() -> new NoSuchElementException("No such book in the library"));
    }

    public static void printAllBooks() {
        library.entrySet().forEach(System.out::println);
    }

    public static void main(String[] args) {
        var book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        var bookPosition = "12CD";

        addBook(book, bookPosition);
        printAllBooks();
        deleteBook(book.title(), book.author(), book.year());
    }
}
