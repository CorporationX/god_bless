package faang.school.godbless;

import faang.school.godbless.task7.Book;

import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void putBook(Map<Book, String> books, Book book, String place) {
        books.put(book, place);
    }

    public static void removeBook(Map<Book, String> books, String title, String author, Integer year) {
        books.remove(new Book(title, author, year));
    }
    public static void findBook(Map<Book, String> books, String title, String author, Integer year) {
        System.out.println(books.get(new Book(title, author, year)));
    }

    public static void allBooksInfo(Map<Book, String> books) {
        for (Map.Entry<Book, String> bookEntry: books.entrySet()) {
            System.out.println("Key - " + bookEntry.getKey() + " Value - " + bookEntry.getValue());
        }
    }
    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<>();
        Book book1 = new Book("Title1","Author1", 2011);
        Book book2 = new Book("Title2","Author2", 2012);
        Book book3 = new Book("Title3","Author3", 2012);
        putBook(library, book1, "Shelf 1");
        putBook(library, book2, "Shelf 2");
        putBook(library, book3, "Shelf 3");
        removeBook(library,"Title1","Author1", 2011);
        findBook(library,"Title2","Author2", 2012);
        allBooksInfo(library);
    }
}