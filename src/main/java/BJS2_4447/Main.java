package BJS2_4447;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> BOOK_IN_LIBRARY = new HashMap<>();

    public static void main(String[] args) {
        Book greenMile = new Book("Зелёная миля", "Стивен Кинг", 2021);
        Book goneWithTheWind = new Book("Унесенные ветром", "Маргарет Митчелл", 2023);
        Book heavenBlessing = new Book("Благословение небожителей. Том 1", "Мосян Тунсю", 2022);
        addBook(greenMile, "A1");
        addBook(goneWithTheWind, "B3");
        addBook(heavenBlessing, "A4");
        deleteBook(greenMile);
        allBooks();
        System.out.println(findBook(heavenBlessing));
        addBook(new Book("test", "test", 2022), "3C");
        addBook(new Book("test1", "test", 2022), "2C");
        allBooks();
    }

    private static void addBook(Book book, String shelf) {
        BOOK_IN_LIBRARY.put(book, shelf);
    }

    private static void deleteBook(Book book) {
        BOOK_IN_LIBRARY.remove(book);
    }

    private static String findBook(Book book) {
        return BOOK_IN_LIBRARY.get(book);
    }

    private static void allBooks() {
        for (var book : BOOK_IN_LIBRARY.entrySet()) {
            System.out.println(book.getKey() + " - " + book.getValue());
        }
    }
}
