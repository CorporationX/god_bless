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

    public String getLocation(String title, String author, int year){
        return cacheBook.get(new Book(title, author, year));
    }

    public


    public static void main(String[] args) {

    }
}
