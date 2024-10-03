package westerosLibrary;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> LIBRARY = new HashMap<>();

    public static void main(String[] args) {

        addBook(new Book("Мёртвые души", "Гоголь Н.В.", 1842), "0001");
        addBook(new Book("Вий", "Гоголь Н.В.", 1835), "0001");
        addBook(new Book("Мастер и Маргарита", "Булгаков М.А.", 1966), "0002");
        addBook(new Book("Бич времён", "Головачев В.В.", 2008), "0003");
        LIBRARY.forEach((book, shelf) -> System.out.println(book + " - " + shelf));

        System.out.println();
        removeBook("Мёртвые души", "Гоголь Н.В.", 1842);
        LIBRARY.forEach((book, shelf) -> System.out.println(book + " - " + shelf));

    }

    public static void addBook(Book book, String shelf) {
        LIBRARY.put(book, shelf);
    }

    public static void removeBook(String title, String author, int year) {
        LIBRARY.remove(new Book(title, author, year));
    }
}
