package school.faang.bjs_68653;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> books = new HashMap<>();
        books.put(new Book("Endovascular", "Alekyan", 2025), "Shelf 1");
        books.put(new Book("Hegel", "Science of Logic", 1812), "Shelf 2");
        books.put(new Book("Nietzsche", "Also sprach Zarathustra", 1883), "Shelf 3");
        books.put(new Book("Orwell", "1984", 1949), "Shelf 2");
        books.put(new Book("Marx", "Das Kapital", 1919), "Shelf 1");

        System.out.println("-------------ADDING A BOOK------------");
        LibrarySystem librarySystem = new LibrarySystem(books);
        librarySystem.addBook("Enchiridion", "Epictetus", 123, "Shelf 1");
        librarySystem.printAllBooks();

        System.out.println("-------------REMOVING A BOOK------------");
        try {
            librarySystem.removeBook("Enchiridion", "Epictetus", 1949);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        librarySystem.printAllBooks();

        System.out.println("-------------REMOVING A BOOK TO CATCH AN EXCEPTION------------");
        try {
            librarySystem.removeBook("Bible", "God", 0);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("-------------FINDING A BOOK------------");
        try {
            librarySystem.findBook("Enchiridion", "Epictetus", 1949);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}
