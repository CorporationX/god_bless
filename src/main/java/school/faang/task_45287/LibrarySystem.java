package school.faang.task_45287;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    public static void addBook(String title, String author, int year, String location, HashMap<Book, String> lib) {
        Book createdBook = new Book(title, author, year);
        lib.put(createdBook, location);
        System.out.println("Your book successful added on " + location);
    }

    public static void removeBook(String title, String author, int year, HashMap<Book, String> lib) {
        Book findBook = new Book(title, author, year);
        lib.remove(findBook);
        System.out.println("Book " + title + " " + author + " " + year + " if successful removed");
    }

    public static void findPolka(String title, String author, int year, HashMap<Book, String> lib) {
        Book findBook = new Book(title, author, year);
        System.out.println("This book is on " + lib.get(findBook));
    }

    public static void booksList(HashMap<Book, String> lib) {
        for (Map.Entry<Book, String> el : lib.entrySet()) {
            System.out.println("Book " + el.getKey() + " " + " is on " + el.getValue());
        }
    }

}
