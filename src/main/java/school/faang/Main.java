package school.faang;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> hashMap = new HashMap<>();
        addBook(hashMap, "16", "Остров сокровищ", "Sergey", "2024");
        addBook(hashMap, "13", "Приключения Тома Сойера", "Dima", "2003");
        addBook(hashMap, "12", "Оно", "Dima", "2003");
        System.out.println("На полке " +
                searchBook(hashMap, "Приключения Тома Сойера", "Dima", "2003") + "\n");
        deleteBookFromKey(hashMap, "Оно", "Dima", "2003");
        printMap(hashMap);
    }

    public static void addBook(Map<Book, String> map, String shelf, String title, String author, String year) {
        Book book = new Book(title, author, year);
        map.put(book, shelf);
    }

    public static Map<Book, String> deleteBookFromKey(Map<Book, String> map, String title, String author, String year) {
        Book book = new Book(title, author, year);
        map.remove(book);
        return map;
    }

    public static String searchBook(Map<Book, String> map, String title, String author, String year) {
        Book book = new Book(title, author, year);
        String bufferShelf = map.get(book);
        return bufferShelf;
    }

    public static void printMap(Map<Book, String> map) {
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            System.out.println(entry.getKey().toString() +
                    " на полке: " + map.get(entry.getKey()));
        }
    }
}