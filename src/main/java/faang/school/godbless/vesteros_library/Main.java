package faang.school.godbless.vesteros_library;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {

        books.put(new Book("abc", "S.V.Smith", 1543), "65");
        books.put(new Book("def", "R.S.Peterson", 1455), "88");
        books.put(new Book("ghi", "O.F.Nolan", 1521), "27");

        System.out.println(books);
        addBook(new Book("jkl", "K.M.Jons", 1490), "38");
        System.out.println(books);
        deleteBook("def", "R.S.Peterson", 1455);
        System.out.println(books);
        System.out.println(getLocation("ghi", "O.F.Nolan", 1521));
        getAllBooks();
    }

    public static void addBook(Book book, String location) {
        books.put(book, location);
    }

    public static void deleteBook(String title, String author, int year) {
        books.remove(new Book(title, author, year));
    }

    public static String getLocation(String title, String author, int year) {
        return books.get(new Book(title, author, year));
    }

    public static void getAllBooks() {
        for (var entry : books.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
