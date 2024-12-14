package school.faang.libraryofwesteros;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {
        Book book1 = new Book("Улисс", "Джойс Дж", 1922);
        Book book2 = new Book("Финансист. Титан. Стоик", "Драйзер Т.", 1947);
        Book book3 = new Book("Война и мир", "Толстой Л.", 1969);
        add(book1, "5");
        add(book2, "14");
        add(book3, "232");
        delete("Улисс", "Джойс Дж", 1922);
        search("Финансист. Титан. Стоик", "Драйзер Т.", 1947);
        listAll();
    }

    public static void add(Book book, String locationBook) {
        books.put(book, locationBook);
    }

    public static void delete(String title, String author, int year) {
        books.remove(new Book(title, author, year));
    }

    public static void search(String title, String author, int year) {
        System.out.println("В полька: " + books.get(new Book(title, author, year)));
    }

    public static void listAll() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            String value = entry.getValue();
            System.out.println(entry.getKey().toString() + " : " + value);
        }
    }

}
