package school.faang.westeros_library;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        var library = new HashMap<Book, String>();
        library.put(new Book("To Kill a Mockingbird", "Harper Lee", 1960), "SP1");
        library.put(new Book("1984", "George Orwell", 1949), "SP2");
        library.put(new Book("The Great Gatsby", "F.Scott Fitzgerald", 1925), "SP3");

        System.out.println("Add book: " + addBook(library, new Book("The Catcher in the Rye", "J.D.Salinger", 1951), "SP5"));
        System.out.println("Book to remove: " + removeBook(library, "1984", "George Orwell", 1949));
        System.out.println("SearchBook: " + searchBook(library, "The Great Gatsby", "F.Scott Fitzgerald", 1925));
        System.out.println("Printed books:");
        printBooks(library);
    }

    private static Book addBook(Map<Book, String> library, Book book, String location) {
        library.put(book, location);
        return book;
    }

    private static Book removeBook(Map<Book, String> library, String title, String author, int year)
            throws NoSuchElementException {
        Book bookToRemove = null;
        for (var entry : library.entrySet()) {
            Book book = entry.getKey();
            if (book.title().equalsIgnoreCase(title) && book.author().equalsIgnoreCase(author) && book.year() == year) {
                bookToRemove = book;
                library.remove(bookToRemove);
            }
        }
        return Optional.ofNullable(bookToRemove).orElseThrow(() ->
                new NoSuchElementException("Book can not be removed, cause: not exits"));
    }

    private static Book searchBook(Map<Book, String> library, String title, String author, int year)
            throws NoSuchElementException {
        Book resultBook = null;
        for (var entry : library.entrySet()) {
            Book book = entry.getKey();
            if (book.title().equalsIgnoreCase(title) && book.author().equalsIgnoreCase(author) && book.year() == year) {
                resultBook = entry.getKey();
            }
        }
        return Optional.ofNullable(resultBook).orElseThrow(() ->
                new NoSuchElementException("Couldn't find particular book"));
    }

    private static void printBooks(Map<Book, String> library) {
        library.forEach((book, place) -> System.out.println(book + " located on shelf: " + place));
    }
}
