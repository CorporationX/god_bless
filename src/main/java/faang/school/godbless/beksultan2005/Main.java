package faang.school.godbless.beksultan2005;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> cacheBook = new HashMap<>();

    public static void addBook(Book book, String location){
        cacheBook.put(book, location);
    }

    public static void removeBook(String title, String author, int year){
        cacheBook.remove(new Book(title, author, year));
    }

    public static String getLocation(String title, String author, int year){
        return cacheBook.get(new Book(title, author, year));
    }

    public static void getAllCacheBook(){
        cacheBook.forEach((key, value) -> System.out.println(key.toString() + ": " + value));
    }


    public static void main(String[] args) {
        Book book1 = new Book("Title1", "Author1", 2001);
        Book book2 = new Book("Title2", "Author2", 2002);
        Book book3 = new Book("Title3", "Author3", 2003);

        addBook(book1, "Shelf1");
        addBook(book2, "Shelf2");
        addBook(book3, "Shelf3");

        System.out.println("All books in cache:");
        getAllCacheBook();

        System.out.println("\nLocation of Title2 by Author2, 2002: " + getLocation("Title2", "Author2", 2002));

        removeBook("Title1", "Author1", 2001);

        System.out.println("\nAll books in cache after removing Title1:");
        getAllCacheBook();
    }
}
