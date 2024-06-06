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
        locationBooks.entrySet()
                .removeIf(entry -> entry.getKey().getTitle().equals(title) &&
                        entry.getKey().getAuthor().equals(author) &&
                        entry.getKey().getYear() == year);
    }

    public static String findBook(String title, String author, int year) {
        return locationBooks.entrySet().stream()
                .filter(entry -> entry.getKey().getTitle().equals(title) &&
                        entry.getKey().getAuthor().equals(author) &&
                        entry.getKey().getYear() == year)
                .map(Map.Entry::getValue).findFirst().orElse(null);
    }

    public static void printAllBooks() {
        locationBooks.forEach((key, value) -> System.out.println(key + " is on " + value));
    }
}