package library_of_westeros;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Book, String> mapBooks = new HashMap<>();
        mapBooks.put(new Book("dark Books", "I", 13), "eighth");
        mapBooks.put(new Book("White Books", "Kate", 72), "wan");
        mapBooks.put(new Book("Black Books", "Andre", 13), "eighth");
        mapBooks.put(new Book("Home Books", "Forka", 11), "free");
        mapBooks.put(new Book("room Books", "Alex", 117), "free");
        mapBooks.put(new Book("dom Books", "Gnida", 113), "for");
        mapBooks.put(new Book("suk Books", "Pidr", 23), "sex");

        LibrarySystem.addBook("fack books", "Pidr",18, "free",mapBooks);
        LibrarySystem.removeBook("dark Books", "I", 13, mapBooks);
        LibrarySystem.findBook("dom Books", "Gnida", 113,mapBooks);
        LibrarySystem.AllBooks(mapBooks);
    }
}
