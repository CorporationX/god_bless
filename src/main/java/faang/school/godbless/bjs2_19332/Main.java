package faang.school.godbless.bjs2_19332;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> library = new HashMap<Book, String>();

    public static void main(String[] args) {
        var book2 = new Book("1", "1", (short) 1);
        var book3 = new Book("1", "1", (short) 2);
        var book4 = new Book("1", "2", (short) 1);
        var book5 = new Book("2", "1", (short) 1);

        put(book2, "shelf2");
        put(book3, "shelf3");
        put(book4, "shelf4");
        put(book5, "shelf5");
        System.out.println("Size 1: " + library.size());

        remove("1", "1", (short) 1);
        System.out.println("Size 2: " + library.size());

        get("2", "1", (short) 1);

        print();
    }

    public static void put(Book book, String location) {
        if (!(book == null || location == null)) {
            library.put(book, location);
        }
    }

    public static void remove(String title, String author, short year) {
        library.remove(new Book(title, author, year));
    }

    public static void get(String title, String author, short year) {
        var location = library.get(new Book(title, author, year));
        if (location != null) {
            System.out.println("Location: " + location);
        } else {
            System.out.println("Book not found");
        }
    }

    public static void print() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println(entry.getKey().toString() + " ----> " + entry.getValue());
        }
    }
}
