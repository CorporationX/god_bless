package faang.school.godbless.westeroslib;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> bookLocations = new HashMap<>() {{
        put(new Book("Title1", "Author1", 2022), "Shelf1");
        put(new Book("Title2", "Author2", 2020), "Shelf2");
        put(new Book("Title3", "Author3", 2021), "Shelf3");
    }};

    public static void main(String[] args) {
        add(new Book("Title4", "Author4", 2019), "Shelf4");
        delete("Title2", "Author2", 2020);
        printLocation("Title1", "Author1", 2022);
        printAll();
    }

    public static void add(Book book, String place) {
        bookLocations.put(book, place);
    }

    public static void delete(String title, String author, int year) {
        bookLocations.remove(new Book(title, author, year));
    }

    public static void printLocation(String title, String author, int year) {
        System.out.println(bookLocations.get(new Book(title, author, year)));
    }

    public static void printAll() {
        for (var entry : bookLocations.entrySet()) {
            if (entry.getKey() != null) {
                System.out.println(String.format("Title: %s, Author: %s, Year: %s, Location: %s", entry.getKey().getTitle(),
                                                                                                  entry.getKey().getAuthor(),
                                                                                                  entry.getKey().getYear(),
                                                                                                  entry.getValue()));
            }
            else {
                System.out.println("Error: book is null");
            }
        }
    }
}
