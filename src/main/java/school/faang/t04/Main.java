package school.faang.t04;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final HashMap<Book, String> BOOKS = new HashMap<>();

    private static void add(Book book, String place) {
        BOOKS.put(book, place);
    }

    private static void remove(Book book) {
        BOOKS.remove(book);
    }

    private static void findAndGetInfo(Book book) {
        System.out.println("Книга найдена на месте: " + BOOKS.get(book));
    }

    private static void printAll() {
        for (Map.Entry<Book, String> entry : BOOKS.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


    public static void main(String[] args) {
        Book bookOne = new Book("Philosopher's Stone", "J.K. Rowling", 2015);
        Book bookTwo = new Book("The Wonder of Nature", "Natural History Museum", 2020);
        Book bookThree = new Book("Fantastic Beasts", "J.K. Rowling, Newt Scamander", 2017);

        add(bookOne, "1 полка 2 ряд");
        add(bookTwo, "3 полка 1 ряд");
        add(bookThree, "5 полка 4 ряд");

        System.out.println("After add : " + BOOKS);
        remove(bookOne);
        System.out.println("After remove : " + BOOKS);
        findAndGetInfo(bookTwo);
        printAll();
    }
}
