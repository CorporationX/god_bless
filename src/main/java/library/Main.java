package library;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        Book book1 = new Book("title1", "author1", 1);
        Book book2 = new Book("title2", "author2", 2);
        Book book3 = new Book("title3", "author3", 3);
        Book book4 = new Book("title4", "author4", 4);

        addBook(book1, "shelf1");
        addBook(book2, "shelf2");
        addBook(book3, "shelf3");
        addBook(book4, "shelf4");
        printLibraryCatalog(library);

        removeBookByDetails("title2","author2",2);
        printLibraryCatalog(library);

        findBookLocation("title1","author1",1);
    }

    private static void printLibraryCatalog(Map<Book, String> library) {
        for (var entry : library.entrySet()) {
            Book book = entry.getKey();
            String location = entry.getValue();
            System.out.println("Title: " + book.title() + ", Author: " + book.author() +
                    ", Year: " + book.year() + ", Location: " + location);
        }
        System.out.println();
    }

    public static void addBook(Book book, String shelf) {
        library.put(book, shelf);
    }


    public static void removeBookByDetails(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        library.remove(bookToRemove);
    }

    public static String findBookLocation(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);

        return library.get(bookToFind);
    }

}
