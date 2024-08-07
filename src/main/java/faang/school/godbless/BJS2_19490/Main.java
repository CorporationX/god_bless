package faang.school.godbless.BJS2_19490;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {

        addBook(new Book("Anna Karenina", "L.N.Tolstoy", 1873), "3 полка снизу");
        addBook(new Book("Buratino", "A.N.Tolstoy", 1936), "1 полка сверху");
        addBook(new Book("Voina and mir", "L.N.Tolstoy", 1805), "3 ролка сверху");
        System.out.println(getAllBooks());

        removeBook("Buratino", "A.N.Tolstoy", 1936);
        System.out.println(getAllBooks());

        System.out.println(findBook("Nothing", "A.N.Tolstoy", 1936));
        System.out.println(findBook("Anna Karenina", "L.N.Tolstoy", 1873));

    }

    static void addBook(Book book, String place) {
        books.put(book, place);
    }

    static void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            books.remove(new Book(title, author, year));
        }
    }

    static String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            return title + ": " + books.get(book);
        }

        return title + ": отсутствует в библиотеке";
    }

    static Map<Book, String> getAllBooks() {
        return books;
    }
}
