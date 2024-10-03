package libraryOfWesteros;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class MainLibrary {
    public static void main(String[] args) {
        Map<Book, String> libraryMap = new HashMap<>();

        addBook(libraryMap, new Book("Bridget Jones's Diary", "Helen Fielding", 1996), "Shelf A");
        addBook(libraryMap, new Book("Charlotte's Web", "E.B. White", 1926), "Shelf B");
        addBook(libraryMap, new Book("Alice in Wonderland", "Lewis Carroll", 1865), "Shelf C");
        addBook(libraryMap, new Book("The Murder of Roger Ackroyd", "Agatha Christie", 1926), "Shelf A");

        printMap(libraryMap);
        removeBook(libraryMap, "Bridget Jones's Diary", "Helen Fielding", 1996);

        System.out.println();
        printMap(libraryMap);

        System.out.println();
        findBook(libraryMap, "The Murder of Roger Ackroyd", "Agatha Christie", 1926);
        findBook(libraryMap, "Winnie-the-Pooh", "A.A. Milne", 1926);

    }

    public static void addBook(Map<Book, String> map, Book book, String location) {
        map.put(book, location);
    }

    public static void removeBook(Map<Book, String> map, String title, String author, int year) {
        List<Book> toRemove = new ArrayList<>();

        for (Map.Entry<Book, String> entry : map.entrySet()) {
            Book book = entry.getKey();
            if (book.getTitle().equals(title) && book.getAuthor().equals(author) && book.getYear() == year) {
                toRemove.add(book);
            }
        }

        for (Book book : toRemove) {
            map.remove(book);
        }
    }

    public static void findBook(Map<Book, String> map, String title, String author, int year) {
        Book book = new Book(title, author, year);
        System.out.println(map.getOrDefault(book, "Книга не найдена"));
    }

    public static void printMap(Map<Book, String> map) {
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            System.out.println("Книга: " + entry.getKey() + "\t\tСекция: " + entry.getValue());
        }
    }
}
