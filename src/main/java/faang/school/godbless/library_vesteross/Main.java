package faang.school.godbless.library_vesteross;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<Book, String> map = new HashMap<>();

    public static void main(String[] args) {
        map.put(new Book("Test1", "author1", "1999"), "12");
        map.put(new Book("Test2", "author2", "1929"), "99");
        map.put(new Book("Test3", "author3", "2000"), "1");

        deleteBook("Test3", "author3", "2000");
        findAllBooks();

        System.out.println();

        addNewBook(new Book("Test4", "author4", "2024"), "100");
        findAllBooks();

        System.out.println();

        findBookPlacement("Test4", "author4", "2024");
    }

    public static void addNewBook(Book book, String placement) {
        map.put(book, placement);
    }

    public static void deleteBook(String title, String author, String year) {
        Book bookForRemove = new Book(title, author, year);
        map.remove(bookForRemove);
    }

    public static void findBookPlacement(String title, String author, String year) {
        Book book = new Book(title, author, year);
        System.out.println(map.get(book));
    }

    public static void findAllBooks() {
        map.forEach(((book, s) -> System.out.printf("%s -> %s%n", book, s)));
    }

}
