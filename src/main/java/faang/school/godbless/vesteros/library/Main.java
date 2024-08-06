package faang.school.godbless.vesteros.library;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final Map<Book, String> bookPlace = new HashMap<>();
    static {
        bookPlace.put(new Book("Magic from Zero to Hero", "Sr. Sem", 1435), "1 room, 3 shelf");
        bookPlace.put(new Book("Swords and knives", "Mr. Jenkins", 1489), "2 room, 1 shelf");
        bookPlace.put(new Book("Dragons", "Mr. Docker", 1287), "1 room, 1 shelf");
        bookPlace.put(new Book("Medicine plants", "Mrs. Yaga", 1305), "3 room, 1 shelf");
        bookPlace.put(new Book("Java", "Mrs. Shild", 1450), "4 room, 1 shelf");
    }

    public static void main(String[] args) {
        printPlace("Magic from Zero to Hero", "Sr. Sem", 1435);
        System.out.println();

        printAll();
    }

    public static void add(Book book, String place) {
        bookPlace.put(book, place);
    }

    public static void remove(String title, String author, int year) {
        bookPlace.remove(new Book(title, author, year));
    }

    private static void printPlace(String title, String author, int year) {
        System.out.println(bookPlace.get(new Book(title, author, year)));
    }

    private static void printAll() {
        bookPlace.forEach((book, place) -> System.out.printf("%s - %s\n", book, place));
    }

}
