package school.faang.task_45287;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    public static void addBook(String title, String author, int year, String location, HashMap<Book, String> Lib) {
        Book NewBook = new Book(title, author, year);
        Lib.put(NewBook, location);
        System.out.println("Your book successful added on " + location);
    }

    public static void removeBook(String title, String author, int year, HashMap<Book, String> Lib) {
        Book findBook = new Book(title, author, year);
        Lib.remove(findBook);
        System.out.println("Book " + title + " " + author + " " + year + " if successful removed");
    }

    public static void FindPolka(String title, String author, int year, HashMap<Book, String> Lib) {
        Book findBook = new Book(title, author, year);
        System.out.println("This book is on " + Lib.get(findBook));
    }

    public static void BooksList(HashMap<Book, String> Lib) {
        for (Map.Entry<Book, String> el : Lib.entrySet()) {
            System.out.println("Book " + el.getKey() + " " + " is on " + el.getValue());
        }
    }

}
