package faang.school.godbless.BJS2_8259;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<>();
        library.put(new Book("Book1", "Author1", 2000), "01");
        library.put(new Book("Book2", "Author2", 2001), "02");
        library.put(new Book("Book3", "Author3", 2002), "03");
        library.put(new Book("Book4", "Author4", 2003), "04");

        printAllBooks(library);
        System.out.println();
        removeBook(library, "Book3", "Author3", 2002);
        printAllBooks(library);
        System.out.println();
        addBook(library, "03", new Book("Book3", "Author3", 2002));
        printBookIndex(library, "Book3", "Author3", 2002);
    }

    public static void addBook(Map<Book, String> map, String index, Book book) {
        map.put(book, index);
    }

    public static void removeBook(Map<Book, String> map, String title, String author, int year) {
        map.remove(new Book(title, author, year));
    }

    public static void printBookIndex(Map<Book, String> map, String title, String author, int year) {
        System.out.println(map.get(new Book(title, author, year)));
    }

    public static void printAllBooks(Map<Book, String> map) {
        map.entrySet().forEach(System.out::println);
    }
}
