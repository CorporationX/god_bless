package school.faang.vesteroslibrary;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    private static Map<Book, String> LIBRARY = new HashMap<>();

    public static void main(String[] args) {
        addToLibrary(new Book("Java Programming", "Java", 2003), "1");
        addToLibrary(new Book("Programming", "Program", 2002), "2");
        addToLibrary(new Book("SQL", "SQL", 2001), "3");
        addToLibrary(new Book("Not Java Programming", "WHO", 2000), "4");

        deleteFromLibrary("Not Java Programming", "WHO", 2000);

        printEveryBookInLibrary();
        searchInLibrary("SQL", "SQL", 2001);

    }

    public static void addToLibrary(Book book, String value) {
        LIBRARY.put(book, value);
    }

    public static void deleteFromLibrary(String title, String author, int year) {
        LIBRARY.remove(new Book(title, author, year));
    }

    public static void searchInLibrary(String title, String author, int year) {
        System.out.println(LIBRARY.get(new Book(title, author,year)));
    }

    public static void printEveryBookInLibrary(){
        for (Map.Entry<Book, String> entry : LIBRARY.entrySet()) {
            System.out.println(entry.getKey() + " Местоположение: " + entry.getValue());
        }
    }
}
