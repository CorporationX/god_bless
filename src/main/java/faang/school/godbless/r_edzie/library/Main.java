package faang.school.godbless.r_edzie.library;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> BOOKS = new HashMap<>();

    public static void main(String[] args) {
        Book b1 = new Book("first", "i", 2002);
        Book b2 = new Book("second", "we", 2000);
        Book b3 = new Book("third", "you", 1990);

        add(b1, "aaa");
        add(b2, "bbb");
        add(b3, "333");

        remove(b2.getTitle(), b2.getAuthor(), b2.getYear());

        System.out.println(find("first", "i", 2002));

        System.out.println("---");

        printAll();
    }

    public static void add(Book book, String place) {
        BOOKS.put(book, place);
    }

    public static void remove(String title, String author, int year) {
        BOOKS.remove(new Book(title, author, year));
    }

    public static String find(String title, String author, int year) {
        return BOOKS.get(new Book(title, author, year));
    }

    public static void printAll() {
        for (Map.Entry<Book, String> entry : BOOKS.entrySet()) {
            Book book = entry.getKey();
            String place = entry.getValue();
            System.out.println(book.getTitle() + " " + book.getAuthor() + " " + book.getYear() + " " + place);
        }
    }
}
