package faang.school.godbless.librarywesteros;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        addBook("Ninja way", "Naruto Uzumaki", 1951, "Shelf 1");
        addBook("Vengeance", "Sasuke Uchiha", 1960, "Shelf 2");
        addBook("1984", "George Orwell", 1949, "Shelf 3");
        addBook("Yellow Flash", "Minato Namikaze", 1851, "Shelf 4");

        removeBook("1984", "George Orwell", 1949);
        findBook("1984", "George Orwell", 1949);
        findAll();


    }

    public static void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
        System.out.println("Book added: " + book + " at " + location);
    }

    public static void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = library.remove(book);
        if (location == null) {
            System.out.println("Book not found: " + book);
        } else {
            System.out.println("Book removed: " + book);
        }
    }

    public static void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            System.out.println("Book found at location: " + library.get(book));
        } else {
            System.out.println("Book not found: " + book);
        }
    }

    public static void findAll() {
        if (library.isEmpty()) {
            System.out.println("Library is empty");
        } else {
            for (Map.Entry<Book, String> entry : library.entrySet()) {
                System.out.println("Book: " + entry.getKey() + " is located at " + entry.getValue());
            }
        }
    }
}
