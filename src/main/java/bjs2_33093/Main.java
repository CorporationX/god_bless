package bjs2_33093;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Book, String> library = new HashMap<>() {{
            put(new Book("Clean Code", "Robert Martin", 2012), "Shelf1");
            put(new Book("Design Patterns", "Erich Gamma", 1961), "Shelf2");
            put(new Book("Harry Potter", "J.K. Rowling", 1997), "Shelf3");
            put(new Book("Atomic habits", "James Clear", 2018), "Shelf1");
        }};

        printAllBooksLocations(library);
        System.out.println(); // Чтобы удобнее вывод было читать

        Book book = new Book("Wolf Hall", "Hilary Mantel", 2009);
        addBook(library, book, "Shelf2");
        searchBook(library, book);
        printAllBooksLocations(library);
        System.out.println(); // Чтобы удобнее вывод было читать

        deleteBook(library, book);
        printAllBooksLocations(library);
    }

    public static void addBook(Map<Book, String> library, Book book, String location) {
        library.put(book, location);
    }

    public static void deleteBook(Map<Book, String> library, Book book) {
        library.remove(book);
    }

    public static void searchBook(Map<Book, String> library, Book book) {
        System.out.println(library.get(book));
    }

    public static void printAllBooksLocations(Map<Book, String> library) {
        for (var entry : library.entrySet()) {
            System.out.printf("Book: %s. Location: %s\n", entry.getKey(), entry.getValue());
        }
    }

}
