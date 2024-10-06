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
        getMap(hashMap);
    }

    public static void addBook(Map<Book, String> map, String shelf, String title, String author, String year) {
        Book book = new Book();
        book.setAuthor(author);
        book.setYear(year);
        book.setTitle(title);
        map.put(book, shelf);
    }

    public static String getBookFromKey(Map<Book, String> map, Book key) {
        return map.get(key);
    }

    public static Map<Book, String> deleteBookFromKey(Map<Book, String> map, String title, String author, String year) {
        Book book = new Book(title, author, year);
        map.remove(book);
        return map;
    }

    public static String searchBook(Map<Book, String> map, String title, String author, String year) {
        Book book = new Book(title, author, year);
        String shelf = "";
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            if (entry.getKey().equals(book)) shelf += entry.getValue();
        }
        return shelf;
    }

    public static void getMap(Map<Book, String> map) {
        String books = "";
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            System.out.println(entry.getKey().toString() +
                    " на полке " + getBookFromKey(map, entry.getKey()));
        }
    }
}