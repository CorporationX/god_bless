package Mathew;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        Book detective = new Book("Sherlock Holmes", "Doyle", 1900);
        Book romance = new Book("Island", "Dephoe", 1950);
        Book prose = new Book("Christine", "King", 1980);

        library.put(detective, "A");
        library.put(romance, "B");
        library.put(prose, "C");
        getAllBooks();
        removeBook(romance.getTitle(), romance.getAuthor(), romance.getYear());
        addBook(romance, "L");
    }

    public static void addBook(Book book, String number) {

        library.put(book, number);
    }

    public static void removeBook(String name, String author, int year) {
        library.remove(new Book(name, author, year));
    }

    public static void getAllBooks() {

        library.forEach(((key, value) -> System.out.println(key + value)));
    }
}