package school.faang.library.of.westeros;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final Map<Book, String> LIBRARY = new HashMap<>();

    public static void main(String[] args) {

        LIBRARY.put(new Book("Анна Каренина","Лев Толстой", 1873), "shelf 28");
        LIBRARY.put(new Book("Гордость и предубеждение","Джейн Остен", 1813), "shelf 15");
        LIBRARY.put(new Book("Евгений Онегин","Александр Пушкин", 1830), "shelf 1");
        LIBRARY.put(new Book("Мартин Иден", "Джек Лондон", 1909), "shelf 12");
        LIBRARY.put(new Book("Мастер и Маргарита", "Михаил Булгаков", 1966), "shelf 18");

        add(new Book("Java Head First", "Кэти Сьерра", 2012), "shelf 24");

        remove("Анна Каренина","Лев Толстой", 1873);
        get("Анна Каренина","Лев Толстой", 1873);

        get("Гордость и предубеждение","Джейн Остен", 1813);

        printAll(LIBRARY);
    }

    public static void add(Book newBook, String bookLocation) {
        LIBRARY.put(newBook, bookLocation);
    }

    public static void remove(String title, String author, int year) {
        LIBRARY.remove(new Book(title, author, year));
    }

    public static void get(String title, String author, int year) {
        System.out.println(LIBRARY.get(new Book(title, author, year)));
    }

    public static void printAll(Map<Book, String> library) {
        for (var entry : library.entrySet()) {
            System.out.println("Location of the book: " + entry.getValue()
            + " | " + "Information about the book: " + entry.getKey());
        }
    }
}
