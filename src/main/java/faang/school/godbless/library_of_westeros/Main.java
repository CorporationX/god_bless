package faang.school.godbless.library_of_westeros;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<Book, String> bookMap = new HashMap<>();

    public static void main(String[] args) {

        bookMap.put(new Book("Battle of the Kings", "Author 1", 1998), "Shelf number 1");
        bookMap.put(new Book("The Storm of Swords", "Author 2", 1993), "Shelf number 2");
        bookMap.put(new Book("Knight of the Seven Kingdoms", "Author 3", 1995), "Shelf number 3");

        printAllBooks(bookMap);
    }

    public static void addBook(Book book, String shelf) {
        if (bookMap.containsKey(book)) {
            throw new IllegalArgumentException("Такая книга уже есть в бибилиотеке");
        }
        bookMap.put(book, shelf);
    }

    public static void removeBookByNameAuthorYear(String title, String author, int year) {
        Book book = new Book(title, author, year);

        if (!bookMap.containsKey(book)) {
            throw new IllegalArgumentException("Такой книги нет в библиотеке");
        }
        bookMap.remove(book);
    }

    public static String findInfoBookByNameAuthorYear(String title, String author, int year) {
        Book book = new Book(title, author, year);

        if (!bookMap.containsKey(book)) {
            throw new IllegalArgumentException("Такой книги нет в библиотеке");
        }
        return bookMap.get(book);
    }

    public static void printAllBooks(Map<Book, String> map) {
        map.entrySet().stream().forEach(System.out::println);
    }
}
