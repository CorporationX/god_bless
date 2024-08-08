package faang.school.godbless.vesteros_lib;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<>(Map.ofEntries(
                Map.entry(new Book("1", "1", 1), "polka 1"),
                Map.entry(new Book("2", "2", 2), "polka 2"),
                Map.entry(new Book("3", "3", 3), "polka 3"),
                Map.entry(new Book("4", "4", 4), "polka 4"),
                Map.entry(new Book("5", "5", 5), "polka 5"))
        );
        printLib(library);
        addBook(library, new Book("5", "6", 6), "polka 6");
        deleteBook(library, "1", "1", 1);
        searchBook(library, "2", "2", 2);
    }

    public static void addBook(Map<Book, String> library, Book book, String place) {
        library.put(book, place);
    }

    public static void deleteBook(Map<Book, String> library, String name, String author, int year) {
        library.remove(new Book(name, author, year));
    }

    public static void searchBook(Map<Book, String> library, String name, String author, int year) {
        System.out.println(
                library.get(new Book(name, author, year))
        );
    }

    public static void printLib(Map<Book, String> library) {
        for (Map.Entry pair: library.entrySet()){
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
