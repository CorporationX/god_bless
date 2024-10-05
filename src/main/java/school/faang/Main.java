package school.faang;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> hashMap = new HashMap<>();
        Book book = new Book("Rt", "Sergey", "2024");
        addBook(hashMap, "Остров сокровищ", "Rt", "Sergey", "2024");
        addBook(hashMap, "Приключения Тома Сойера", "Ts", "Dima", "2003");
        System.out.println(getBookFromKey(hashMap, book));
        getMap(hashMap);
    }

    public static void addBook(Map<Book, String> map, String value, String title, String author, String year) {
        Book book = new Book();
        book.setAuthor(author);
        book.setYear(year);
        book.setTitle(title);
        map.put(book, value);
    }

    public static String getBookFromKey(Map<Book, String> map, Book key) {
        return map.get(key);
    }

    public static void deleteBookFromKey(Map<Book, String> map, String title, String author, String year) {
        Book book = new Book(title, author, year);
        map.remove(getBookFromKey(map, book));

    }

    public static void getMap(Map<Book, String> map) {
        String books = "";
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            books += getBookFromKey(map, entry.getKey()) + "\n";
        }
        System.out.println("Books:\n" + books);
    }
}