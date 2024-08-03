package faang.school.godbless.BJS2_19234;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Book, String> books = new HashMap<>();
        books.put(new Book("Metro 2033", "Robert", 2005), "B2");
        books.put(new Book("Metro 2034", "Robert", 2010), "B2");
        books.put(new Book("Metro 2035", "Robert", 2015), "F13");

        Book.addLocationBook(books, new Book("Robert", "Robert", 2000), "C5");
        System.out.println(books);

        Book.removeLocationBook(books, new Book("Metro 2035", "Robert", 2015));
        System.out.println(books);

        String locationBook = Book.getLocationBook(books, new Book("Robert", "Robert", 2000));
        System.out.println(locationBook);

        Book.printLocationBooks(books);
    }
}
