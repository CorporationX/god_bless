package school.faang.westeros_library;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        var book = new Book("The Catcher in the Rye", "J.D.Salinger", 1951);
        var library = new HashMap<Book, String>();
        library.put(new Book("To Kill a Mockingbird", "Harper Lee", 1960), "SP1");
        library.put(new Book("1984", "George Orwell", 1949), "SP2");
        library.put(new Book("The Great Gatsby", "F.Scott Fitzgerald", 1925), "SP3");

        System.out.println("Add book: " + addBook(library, book, "SP5"));
        System.out.println("Book to remove: " + removeBook(library, book));
        System.out.println("SearchBook: " + searchBook(library, book));
        System.out.println("Printed books:");
        printBooks(library);
    }

    private static Book addBook(Map<Book, String> library, Book book, String location) {
        library.put(book, location);
        return book;
    }

    private static Optional<Book> removeBook(Map<Book, String> library, Book book) {
        library.remove(book);
        return Optional.of(book);
    }

    private static Optional<Book> searchBook(Map<Book, String> library, Book book) {
        library.get(book);
        return Optional.of(book);
    }

    private static void printBooks(Map<Book, String> library) {
        library.forEach((book, place) -> System.out.println(book + " located on shelf: " + place));
    }
}
