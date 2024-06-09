package faang.school.godbless.hashMap.westerosLibrary;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        add("title1", "author1", 1990, "shelf2");
        add("title2", "author1", 2005, "shelf5");
        add("title3", "author2", 2020, "shelf1");
        add("title4", "author3", 2000, "shelf1");

        printLibrary();
        System.out.println();

        delete("title1", "author1", 1990);

        printLibrary();
        System.out.println();

        printPlaceByBook("title2", "author1", 2005);
    }

    public static void add(String title, String author, int year, String place) {
        if (place == null || place.isEmpty() || place.isBlank()) {
            throw new IllegalArgumentException("Shelf can`t be empty");
        }
        library.putIfAbsent(new Book(title, author, year), place);
    }

    public static void delete(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.remove(book) == null) {
            throw new NotFoundException("Book " + title + " by " + author + " not found");
        }
    }

    public static void printPlaceByBook(String title, String author, int year) {
        String place = library.get(new Book(title, author, year));
        if (place == null) {
            throw new NotFoundException("Book " + title + " by " + author + " not found");
        }
        System.out.println(place);
    }

    public static void printLibrary() {
        for (Map.Entry<Book, String> book : library.entrySet()) {
            System.out.println(book.getKey().toString() + "; place: " + book.getValue());
        }
    }
}