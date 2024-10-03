package westerosLibrary;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {

        add(new Book("Мёртвые души", "Гоголь Н.В.", 1842), "0001");
        add(new Book("Вий", "Гоголь Н.В.", 1835), "0001");
        add(new Book("Мастер и Маргарита", "Булгаков М.А.", 1966), "0002");
        add(new Book("Бич времён", "Головачев В.В.", 2008), "0003");

        library.forEach((book, shelf) -> System.out.println(book + " - " + shelf));

    }

    public static void add(Book book, String shelf) {
        library.put(book, shelf);
    }
}
