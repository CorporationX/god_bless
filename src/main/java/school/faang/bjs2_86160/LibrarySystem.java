package school.faang.bjs2_86160;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    private static final Map<Book, String> bookMap = new HashMap<>();

    public static void addBook(String title, String author, int year, String location) {
        Book newBook = new Book(title, author, year);
        bookMap.putIfAbsent(newBook, location);
    }

    public static void removeBook(String title, String author, int year) {
        Book bookForRemoval = new Book(title, author, year);
        if (bookMap.remove(bookForRemoval) == null) {
            System.out.println("Book was not found.");
            return;
        }
        System.out.println(bookForRemoval.getTitle() + " was removed");
    }

    public static void findBook(String title, String author, int year) {
        Book bookForSearch = new Book(title, author, year);
        if (bookMap.containsKey(bookForSearch)) {
            System.out.println(bookForSearch.getTitle() + " is located at " + bookMap.get(bookForSearch));
        } else {
            System.out.println("Book is not found.");
        }
    }

    public static void printAllBooks() {
        System.out.println("Current list of books:");
        for (Map.Entry<Book, String> booksList : bookMap.entrySet()) {
            System.out.printf("%s -> %s%n", booksList.getKey().getTitle(), booksList.getValue());
        }
    }
}