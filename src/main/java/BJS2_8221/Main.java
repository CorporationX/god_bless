package BJS2_8221;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Book, String> locationBooks = new HashMap<>();

    public static void main(String[] args) {
        addBook("The trial", "Franz Kafka", 1925, "1C");
        addBook("The dreams in the witch-house", "Lovecraft", 1933, "2C");
        addBook("ABC", "Kirill and Methodius", 863, "1A");

        removeBook("The trial", "Franz Kafka", 1925);

        System.out.println(findBook("ABC", "Kirill and Methodius", 863));

        printAllBooks();
    }

    public static void addBook(String title, String author, int year, String location) {
        locationBooks.put(new Book(title, author, year), location);
    }

    public static void removeBook(String title, String author, int year) {
        locationBooks.remove(new Book(title, author, year));
    }

    public static String findBook(String title, String author, int year) {
        return locationBooks.get(new Book(title, author, year));
    }

    public static void printAllBooks() {
        locationBooks.forEach((key, value) -> System.out.println(key + " is on " + value));
    }
}