package faang.school.godbless.libralyVesterossa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<Book, String> libraly = new HashMap<>();
        addBook(libraly, new Book("harray potter", "hz", 1), "001");
        addBook(libraly, new Book("1111", "hz1111", 1111), "002");
        addBook(libraly, new Book("22222", "hz2222", 1222), "003");
        addBook(libraly, new Book("3333r", "hz3333", 13333), "004");
        System.out.println("_______________________________________");
        System.out.println(getAllBooks(libraly));
        System.out.println("_______________________________________");
        removeBook(libraly, "3333r", "hz3333", 13333);
        removeBook(libraly, "harray potter", "hz", 1);
        System.out.println("_______________________________________");
        System.out.println(getAllBooks(libraly));
        System.out.println("_______________________________________");
        System.out.println(getBook(libraly, "22222", "hz2222", 1222));
        System.out.println("_______________________________________");
    }

    static void addBook(HashMap<Book, String> libraly, Book book, String area) {
        libraly.putIfAbsent(book, area);
    }

    static void removeBook(HashMap<Book, String> libraly, String title, String author, int year) {
        for (Map.Entry<Book, String> bookStringEntry : libraly.entrySet()) {
            Book key = bookStringEntry.getKey();
            if (key.getAuthor().equals(author) && key.getYear() == year && key.getTitle().equals(title)) {
                libraly.remove(key);
                break;
            }
        }
    }

    static String getBook(HashMap<Book, String> libraly, String title, String author, int year) {
        for (Map.Entry<Book, String> bookStringEntry : libraly.entrySet()) {
            Book key = bookStringEntry.getKey();
            if (key.getAuthor().equals(author) && key.getYear() == year && key.getTitle().equals(title)) {
                return bookStringEntry.getValue();
            }
        }
        return null;
    }
//
    static List<Book> getAllBooks(HashMap<Book, String> libraly) {
        List<Book> books = new ArrayList<>();
        for (Map.Entry<Book, String> bookStringEntry : libraly.entrySet()) {
            books.add(bookStringEntry.getKey());
        }
        return books;
    }
}
