package faang.school.godbless.BJS28218;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> bookLibrary = new HashMap<>();
        addBook(new Book("Lives of Four Kings", "Grand Maester Kaeth", 225),
                "upper shelf", bookLibrary);
        addBook(new Book("The Death of Dragons", "Maester Viet", 256),
                "middle shelf", bookLibrary);
        addBook(new Book("Sparrows: we are power", "The High Sparrow", 305),
                "lower shelf", bookLibrary);

        printBooks(bookLibrary);

        removeBook("Sparrows: we are power", "The High Sparrow", 305, bookLibrary);

        printBooks(bookLibrary);

        System.out.println(searchBook(
                "The Death of Dragons", "Maester Viet", 256, bookLibrary));
        System.out.println(searchBook(
                "Sparrows: we are power", "The High Sparrow", 305, bookLibrary));
    }

    public static void addBook(Book book, String shelfPosition, Map<Book, String> bookLibrary) {
        bookLibrary.put(book, shelfPosition);
    }

    public static void removeBook(String bookName, String author, int year, Map<Book, String> bookLibrary) {
        Book book = new Book(bookName, author, year);
        bookLibrary.remove(book);
    }

    public static String searchBook(String bookName, String author, int year, Map<Book, String> bookLibrary) {
        Book book = new Book(bookName, author, year);
        if (bookLibrary.containsKey(book)) {
            return "Book " + bookName + " in the " + bookLibrary.get(book);
        } else {
            return "Book " + bookName + " not found in the library";
        }
    }

    public static void printBooks(Map<Book, String> bookLibrary) {
        System.out.println("Library includes next books:");
        bookLibrary.forEach((key, value) -> System.out.println(key + " Location in Library: " + value));
    }
}

