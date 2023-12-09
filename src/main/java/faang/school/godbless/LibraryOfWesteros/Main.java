package faang.school.godbless.LibraryOfWesteros;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> mapOfBooks = new HashMap<>();
        mapOfBooks.put(new Book("A Scandal in Bohemia", "Arthur Conan Doyle", 1891), "A-20");
        mapOfBooks.put(new Book("Death on the Nile", "Agatha Christie", 1937), "A-63");
        Book wutheringHeights = new Book("Wuthering Heights", "Emily Brontë", 1847);

        addBook(mapOfBooks, wutheringHeights, "E-5");
        searchBook(mapOfBooks, "Wuthering Heights", "Emily Brontë", 1847);
        allBooks(mapOfBooks);

        deleteBook(mapOfBooks, "A Scandal in Bohemia", "Arthur Conan Doyle", 1891);
        allBooks(mapOfBooks);
    }

    public static void addBook(Map<Book, String> mapBook, Book book, String position) {
        mapBook.put(book, position);
    }

    public static void deleteBook(Map<Book, String> mapBook, String title, String author, int year) {
        mapBook.remove(new Book(title, author, year));
    }

    public static void searchBook(Map<Book, String> mapBook, String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (mapBook.containsKey(book)) {
            System.out.println("Книгу '" + title + "' можно найти на " + mapBook.get(book));
        } else
            System.out.println("Такой книги нет");
    }

    public static void allBooks(Map<Book, String> mapBook) {
        System.out.println("Все книги в библиотеке:");
        for (Map.Entry<Book, String> entry : mapBook.entrySet())
            System.out.println(entry);
    }


}
