package westerosLibrary;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> LIBRARY = new HashMap<>();

    public static void main(String[] args) {

        Book book1 = new Book("Мёртвые души", "Гоголь Н.В.", 1842);
        Book book2 = new Book("Вий", "Гоголь Н.В.", 1835);
        Book book3 = new Book("Мастер и Маргарита", "Булгаков М.А.", 1966);
        Book book4 = new Book("Бич времён", "Головачев В.В.", 2008);
        addBook(book1, "0001");
        addBook(book2, "0001");
        addBook(book3, "0002");
        addBook(book4, "0003");
        LIBRARY.forEach((book, shelf) -> System.out.println(book + " - " + shelf));


        System.out.println();
        removeBook("Мёртвые души", "Гоголь Н.В.", 1842);
        LIBRARY.forEach((book, shelf) -> System.out.println(book + " - " + shelf));

        System.out.println();
        System.out.println(getShelf(book1));
        System.out.println(getShelf(book4));

    }

    public static void addBook(Book book, String shelf) {
        LIBRARY.put(book, shelf);
    }

    public static void removeBook(String title, String author, int year) {
        LIBRARY.remove(new Book(title, author, year));
    }

    public static String getShelf(Book book) {
        return LIBRARY.get(book);
    }
}
