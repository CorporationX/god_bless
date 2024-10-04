package school.faang.abstraction;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<Book, String> BOOK_TO_SHELF = new HashMap<>();

    static {
        BOOK_TO_SHELF.put(new Book("Book1", "Alex", 2000), "shelf_1");
        BOOK_TO_SHELF.put(new Book("Book2", "Ivan", 1900), "shelf_2");
    }

    public static void main(String[] args) {
        String title = "Test Book";
        String author = "The Best Author";
        int year = 1000;
        String shelf = "shelf_2";

        addBookToShelf(new Book(title, author, year), shelf);
        String foundShelf = findBookShelf(title, author, year);
        System.out.printf("%s shelf: %s%n", title, foundShelf);
        removeBook(title, author, year);
        printLibraryContents();
    }

    public static void addBookToShelf(Book book, String shelf) {
        BOOK_TO_SHELF.put(book, shelf);
    }

    public static void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        BOOK_TO_SHELF.remove(book);
    }

    public static String findBookShelf(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return BOOK_TO_SHELF.get(book);
    }

    public static void printLibraryContents() {
        for (Map.Entry<Book, String> entry : BOOK_TO_SHELF.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
