package faang.school.godbless.westeros;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        addBook(new Book("A Game of Thrones", "George R. R. Martin", 1996), "Shelf 1");
        addBook(new Book("A Clash of Kings", "George R. R. Martin", 1998), "Shelf 1");
        addBook(new Book("A Storm of Swords", "George R. R. Martin", 2000), "Shelf 2");

        findBook(new Book("A Game of Thrones", "George R. R. Martin", 1996));

        removeBook(new Book("A Clash of Kings", "George R. R. Martin", 1998));

        printLibrary();
    }

    public static void addBook(Book book, String location) {
        library.put(book, location);
        System.out.println(book + " has been added to " + location);
    }

    public static void removeBook(Book book) {
        if (library.containsKey(book)) {
            library.remove(book);
            System.out.println(book + " has been removed from the library.");
        } else {
            System.out.println(book + " is not found in the library.");
        }
    }

    public static void findBook(Book book) {
        if (library.containsKey(book)) {
            System.out.println(book + " is located at " + library.get(book));
        } else {
            System.out.println(book + " is not found in the library.");
        }
    }

    public static void printLibrary() {
        Set<Map.Entry<Book, String>> entries = library.entrySet();
        for (Map.Entry<Book, String> entry : entries) {
            System.out.println(entry.getKey() + " is located at " + entry.getValue());
        }
    }
}
