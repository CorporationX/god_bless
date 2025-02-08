package school.faang.vesternlibrary;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static Map<Book, String> bookPlace = new HashMap<>();

    public static boolean addBook(String title, String author, int year, String location) {
        if (title.isBlank() || author.isBlank() || year == 0 || location.isBlank()) {
            throw new IllegalArgumentException("Title, Author,year and location are required");
        }
        Book newBook = new Book(title, author, year);
        if (bookPlace.containsKey(newBook)) {
            System.out.println("Book already exists");
            return false;
        }
        bookPlace.put(newBook, location);
        return true;
    }

    public static boolean removeBook(String title, String author, int year) {
        if (title.isBlank() || author.isBlank() || year == 0) {
            throw new IllegalArgumentException("Title, Author,year and location are required");
        }
        Book newBook = new Book(title, author, year);
        if (!bookPlace.containsKey(newBook)) {
            System.out.println("Book does not exist");
            return false;
        }

        bookPlace.remove(newBook);
        return true;
    }

    public static boolean findBook(String title, String author, int year) {
        if (title.isBlank() || author.isBlank() || year == 0) {
            throw new IllegalArgumentException("Title, Author,year and location are required");
        }
        Book newBook = new Book(title, author, year);
        if (!bookPlace.containsKey(newBook)) {
            System.out.println("Book is not find");
            return false;
        }
        System.out.println(String.format("Book %s is found, it location is %s ",
                newBook.getTitle(), bookPlace.get(newBook)));
        return true;
    }

    public static void printAllBooks() {
        for (Map.Entry<Book, String> entry : bookPlace.entrySet()) {
            System.out.println(String.format("Book %s is found, it location is %s ",
                    entry.getKey().getTitle(), entry.getValue()));
        }
    }

}
