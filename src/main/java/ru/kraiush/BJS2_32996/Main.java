package ru.kraiush.BJS2_32996;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> BOOKS = new HashMap<>();

    private static void addBook(Book book, String location) {
        BOOKS.put(book, location);
    }

    private static void removeBook(String title, String author, int year) {
        Book bookForRemoval = new Book(title, author, year);
        BOOKS.remove(bookForRemoval);
    }

    private static void findBookLocation(String title, String author, int year) {
        Book bookForSearch = new Book(title, author, year);
        System.out.println(BOOKS.get(bookForSearch));
    }

    private static void getBooks() {
        for (Map.Entry<Book, String> entry: BOOKS.entrySet()) {
            System.out.println(entry.getKey() + " Location: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Book book1 = new Book("War and Peace", "Lev Tolstoy", 2005);
        Book book2 = new Book("The financier", "Theodor Draizer", 2010);
        Book book3 = new Book("The mockingbird", "Lee Harper", 2017);
        Book book4 = new Book("Gone with the wind", "Margaret Mitchel", 2018);
        BOOKS.put(book1, "Row: 5, Block: 4, Shelf: 4");
        BOOKS.put(book2, "Row: 8, Block: 1, Shelf: 5");
        BOOKS.put(book3, "Row: 1, Block: 4, Shelf: 4");

        addBook(book4, "Row: 1, Block: 4, Shelf: 4");
        removeBook("The mockingbird", "Lee Harper", 2017);
        findBookLocation("War and Peace", "Lev Tolstoy", 2005);
        getBooks();
    }
}
