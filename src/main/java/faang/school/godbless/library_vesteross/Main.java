package faang.school.godbless.library_vesteross;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<Book, String> map = new HashMap<>();

    public static void main(String[] args) {
        map.put(new Book("Test1", "author1", "1999"), "12");
        map.put(new Book("Test2", "author2", "1929"), "99");
        map.put(new Book("Test3", "author3", "2000"), "1");

        deleteByYear("2000");
        findAllBooks();

        System.out.println();

        addNewBook(new Book("Test4", "author4", "2024"), "100");
        findAllBooks();

        System.out.println();
        findPlacementByTitle("Test4");
    }

    public static void addNewBook(Book book, String placement) {
        map.put(book, placement);
    }

    public static void deleteByTitle(String title) {
        for (Book book : map.keySet()) {
            if (book.getTitle().equals(title)) {
                map.remove(book);
                break;
            }
        }
    }

    public static void deleteByAuthor(String author) {
        for (Book book : map.keySet()) {
            if (book.getAuthor().equals(author)) {
                map.remove(book);
                break;
            }
        }
    }

    public static void deleteByYear(String year) {
        for (Book book : map.keySet()) {
            if (book.getYear().equals(year)) {
                map.remove(book);
                break;
            }
        }
    }

    public static void findPlacementByTitle(String title) {
        for (Book book : map.keySet()) {
            if (book.getTitle().equals(title)) {
                System.out.println(map.get(book));
                break;
            }
        }
    }

    public static void findPlacementByAuthor(String author) {
        for (Book book : map.keySet()) {
            if (book.getAuthor().equals(author)) {
                System.out.println(map.get(book));
                break;
            }
        }
    }

    public static void findPlacementByYear(String year) {
        for (Book book : map.keySet()) {
            if (book.getYear().equals(year)) {
                System.out.println(map.get(book));
                break;
            }
        }
    }

    public static void findAllBooks() {
        map.forEach(((book, s) -> System.out.printf("%s -> %s%n", book, s)));
    }



}
