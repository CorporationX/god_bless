package faang.school.godbless.westeroslibrary;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final Map<Book, String> BOOK_MAP = new HashMap<>();

    public static void main(String[] args) {
        addBook("A Game of Thrones", "George R. R. Martin", 1996, "1");
        addBook("A Clash of Kings", "George R. R. Martin", 1998, "4");
        addBook("A Fist for Crows", "George R. R. Martin", 2005, "8");
        addBook("A Dance with Dragons", "George R. R. Martin", 2011, "3");
        removeBook("A Dance with Dragons", "George R. R. Martin", 2011);
        findBook("A Dance with Dragons", "George R. R. Martin", 2011);
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
        Book book = new Book(title, author, year);
        if (BOOK_MAP.containsKey(book)) {
            System.out.printf("The book '%s' is on a shelf %s\n\n", title, BOOK_MAP.get(book));
        } else {
            System.out.println("There is no such book in the library");
        }
    }

    public static void showAllBooks() {
        for (Map.Entry<Book, String> book : BOOK_MAP.entrySet()) {
            System.out.printf("The book '%s' is on a shelf %s\n", book.getKey().getTitle(), book.getValue());
        }
    }
}