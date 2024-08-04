package faang.school.godbless.bjs2_19211;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> locationBooks = new HashMap<>();
        locationBooks.put(new Book("Harry Potter", "J.K. Rowling", 1991), "a1");
        locationBooks.put(new Book("Война и мир", "Лев Толстой", 1900), "a11");
        locationBooks.put(new Book("Человек-невидимка", "Ральф Эллисон", 1950), "b28");


        addLocationBook(locationBooks, new Book("Убить пересмешника", "Харпер Ли", 2000), "a4");
        System.out.println(locationBooks);

        removeLocationBook(locationBooks, new Book(" Человек-невидимка", "Ральф Эллисон", 1950));
        System.out.println(locationBooks);

        String locationBook = getLocationBook(locationBooks, new Book("Дневник Анны Франк", "Анна Франк", 2013));
        System.out.println(locationBook);

        printLocationBooks(locationBooks);
    }

    private static void addLocationBook(Map<Book, String> locationBooks, Book book, String location) {
        locationBooks.put(book, location);
    }

    private static void removeLocationBook(Map<Book, String> locationBooks, Book book) {
        locationBooks.remove(book);
    }

    private static String getLocationBook(Map<Book, String> locationBooks, Book book) {
        return locationBooks.get(book);
    }

    private static void printLocationBooks(Map<Book, String> locationBooks) {
        for (Map.Entry<Book, String> entry : locationBooks.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
