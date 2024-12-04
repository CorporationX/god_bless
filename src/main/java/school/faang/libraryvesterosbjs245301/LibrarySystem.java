package school.faang.libraryvesterosbjs245301;

import java.util.Map;

public class LibrarySystem {
    public static void addBook(String title, String author, int year, String location) {
        Main.numberShelf.put(new Book(title, author, year), location);
        System.out.println("Book " + title + " add at shelf: " + location);
    }

    public static void removeBook(String title, String author, int year) {
        if (Main.numberShelf.remove(new Book(title, author, year)) != null) {
            System.out.println("Book " + title + " delete");
        } else {
            System.out.println("Book don't find");
        }
    }

    public static void findBook(String title, String author, int year) {
        if (Main.numberShelf.get(new Book(title, author, year)) != null) {
            System.out.println("Book " + title + " find");
        } else {
            System.out.println("Book don't find");
        }
    }

    public static void printAllBooks() {
        if (Main.numberShelf.isEmpty()) {
            System.out.println("Library is empty");
        } else {
            for (Map.Entry<Book, String> entry : Main.numberShelf.entrySet()) {
                System.out.println(entry.getKey() + " find in " + entry.getValue());
            }
        }
    }
}
