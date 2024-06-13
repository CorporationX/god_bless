package faang.school.godbless.library;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {

        Book seawolf = new Book("Snow", "Lannister", 1293);
        books.put(new Book("Tom Sayer", "Mark Twain", 1976), "Shelf A");
        books.put(new Book("Dragons", "Snow", 1076), "Shelf C");
        books.put(new Book("Wolf", "Snow", 1078), "Shelf C");
        books.put(new Book("Drakaris", "Snow", 1071), "Shelf C");

        addBook(seawolf, "Shelf B");
        addBook(new Book("Lannister", "The songs of Lannister", 1290), "Shelf B");
        getAllBooks();
        System.out.println(findBookOnShelf("Tom Sayer", "Mark Twain", 1976));
        
    }

    public static void addBook(Book book, String place) {
        books.put(book, place);
    }

    public static void removeBook(String title, String author, int year) {
        books.remove(new Book(title, author, year));
    }

    public static String findBookOnShelf(String title, String author, int year) {
        return books.get(new Book(title, author, year));
    }

    public static void getAllBooks() {
        System.out.println(books.entrySet());

    }
}
