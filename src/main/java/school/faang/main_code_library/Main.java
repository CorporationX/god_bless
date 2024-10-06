package school.faang.main_code_library;

import school.faang.main_code_library.Book;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> booksMap = new HashMap<>();

    public static void main(String[] args) {
        Book firstBook = new Book("War and peace", "Tolstoy", 1999);
        Book secondBook = new Book("Dybrovski", "Pushkin", 1989);
        Book thirdBook = new Book("Tom soer", "Dostoevsky", 2000);

        addBook(firstBook, "firstShelf");
        addBook(secondBook, "secondShelf");
        addBook(thirdBook, "thirdShelf");

        removeBook("War and peace", "Tolstoy", 1999);

        getBook("Tom soer", "Dostoevsky", 2000);

        printAllLines();
    }

    public static void addBook(Book book, String shelf) {
        booksMap.put(book, shelf);
    }

    public static void removeBook(String title, String author, int year) {
        booksMap.remove(new Book(title, author, year));
    }

    public static void getBook(String title, String author, int year) {
        System.out.println(booksMap.get(new Book(title, author, year)));
    }

    public static void printAllLines() {
        for(Map.Entry<Book, String> entry : booksMap.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }
}