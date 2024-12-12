package school.faang.task_45408;

import java.util.Map;

public class LibrarySystem {
    public static void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        Main.bookShelveInfo.put(book, location);
    }

    public static void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        Main.bookShelveInfo.remove(book);
    }

    public static String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (Main.bookShelveInfo.containsKey(book)) {
            return Main.bookShelveInfo.get(book);
        }
        return "Not found";
    }

    public static void printAllBooks() {
        for (Map.Entry<Book, String> entry : Main.bookShelveInfo.entrySet()) {
            System.out.println("Book: " + entry.getKey() + " is on the " + entry.getValue() + " shelve");
        }
    }

}
