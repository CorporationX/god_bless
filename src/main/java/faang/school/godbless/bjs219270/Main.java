package faang.school.godbless.bjs219270;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {
        books.put(new Book("The houses of North", "Meister Luwin", 217), "1 row, 2 shelves, number 18");
        books.put(new Book("Targaryen Dragons", "Meister Pycelle", 280), "3 row, 4 shelves, number 9");
        books.put(new Book("The rebellion of Baratheon", "Meister Aemon", 285), "2 row, 3 shelves, number 11");

        addBook(new Book("Fire and Blood", "Pycelle", 267), "1 row, 3 shelves, number 1");
        findBook(new Book("Fire and Blood", "Pycelle", 267));
        removeBook(new Book("Fire and Blood", "Pycelle", 267));
        allBooks();
    }

    public static void allBooks() {
        books.forEach((book, place) -> System.out.println(book + " Place: " + place));
    }

    public static void addBook(Book book, String place) {

        if (!books.containsKey(book)) {
            books.put(book, place);
        } else {
            System.out.println("This book is already added");
        }
    }

    public static void removeBook(Book book) {
        books.remove(book);
    }

    public static void findBook(Book book) {
        System.out.println(books.get(book));
    }
}
