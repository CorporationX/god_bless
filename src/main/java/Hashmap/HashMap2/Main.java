package Hashmap.HashMap2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> map = new HashMap<>();
        Book book1 = new Book("title1", "author1", 1998);
        Book book2 = new Book("title2", "author2", 1998);
        Book book3 = new Book("title3", "author3", 1999);
        Book book4 = new Book("title4", "author4", 1968);
        Book book5 = new Book("title5", "author5", 1968);
        put(map, book1, "place 1");
        put(map, book2, "place2");
        put(map, book3, "place3");
        put(map, book4, "place4");
        put(map, book5, "place5");
        String s = get(map, book1);
        System.out.println(s);
        remove(map, book1);
        List<String> allBook = getAllBook(map);
        System.out.println(allBook);
    }

    public static void put(Map<Book, String> map, Book book, String place) {
        map.put(book, place);
    }

    public static void remove(Map<Book, String> map, Book book) {
        map.remove(book);
    }

    public static String get(Map<Book, String> map, Book book) {
        String placeBook = map.get(book);
        return placeBook;
    }

    public static List<String> getAllBook(Map<Book, String> map) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            String title = entry.getKey().getTitle();
            String author = entry.getKey().getAuthor();
            int year = entry.getKey().getYear();
            String placeBook = entry.getValue();
            list.add(title + " " + author + " " + year + " " + placeBook);
        }
        return list;
    }
}
