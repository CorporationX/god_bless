package faang.school.godbless.westeroslibrary;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final Map<Book, String> BOOK_MAP = new HashMap<>();

    public static void main(String[] args) {
        BOOK_MAP.put(new Book("A Game of Thrones", "George R. R. Martin", 1996), "1");
        BOOK_MAP.put(new Book("A Clash of Kings", "George R. R. Martin", 1998), "4");
        BOOK_MAP.put(new Book("A Fist for Crows", "George R. R. Martin", 2005), "8");

        addBook("A Dance with Dragons", "George R. R. Martin", 2011, "3");
        findBook("A Dance with Dragons", "George R. R. Martin", 2011);
        removeBook("A Dance with Dragons", "George R. R. Martin", 2011);
        showAllBooks();
    }

    public static void addBook(String title, String author, int year, String shelf) {
        Book book = new Book(title, author, year);
        BOOK_MAP.put(book, shelf);
    }

    public static void removeBook(String title, String author, int year) {
        BOOK_MAP.remove(new Book(title, author, year));
    }

    public static void findBook(String title, String author, int year) {
        String shelf = BOOK_MAP.get(new Book(title, author, year));
        System.out.printf("The book '%s' is on a shelf %s\n\n", title, shelf);
    }

    public static void showAllBooks() {
        for (Map.Entry<Book, String> book : BOOK_MAP.entrySet()) {
            System.out.printf("The book '%s' is on a shelf %s\n", book.getKey().getTitle(), book.getValue());
        }
    }
}