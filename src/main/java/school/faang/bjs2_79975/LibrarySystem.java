package school.faang.bjs2_79975;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static HashMap<Book, String> library = new HashMap<>();

    public static void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
    }

    public static void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        library.remove(book);
    }

    public static void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);

        if (library.containsKey(book)) {
            System.out.println(library.get(book));
        } else {
            System.out.println("Книга не найдена");
        }
    }

    public static void printAllBooks() {
        for(Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println(entry.getKey());
        }

        System.out.println();
    }
}
