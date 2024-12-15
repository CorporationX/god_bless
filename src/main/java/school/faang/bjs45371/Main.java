package school.faang.bjs45371;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> booksLocation = new HashMap<>();

        booksLocation.put(new Book("Prince and Pauper", "Twen", 1988), "Some location");
        booksLocation.put(new Book("1984", "George Orwell", 1949), "Shelf A1");
        booksLocation.put(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925), "C3");

        LibrarySystem localLibrary = new LibrarySystem();
        localLibrary.addBook("Prince and Pauper", "Twen", 1988, "Some location");
        localLibrary.addBook("1984", "George Orwell", 1949, "Shelf A1");
        localLibrary.addBook("The Great Gatsby", "F. Scott Fitzgerald", 1925, "C3");
        localLibrary.addBook("Moby Dick", "Herman Melville", 1851, "D4");

        localLibrary.printAllBooks();

        String notExistingBook = localLibrary.findBook("Wrong", "Nobody", -1);
        System.out.println(notExistingBook);
        String existingBook = localLibrary.findBook("Moby Dick", "Herman Melville", 1851);
        System.out.println(existingBook);

        notExistingBook = localLibrary.removeBook("Wrong", "Nobody", -1);
        System.out.println(notExistingBook);
        existingBook = localLibrary.removeBook("Moby Dick", "Herman Melville", 1851);
        System.out.println(existingBook);

        localLibrary.printAllBooks();
    }
}
