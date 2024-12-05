package school.faang.bsj245398;

import java.util.HashMap;
import java.util.Map;


public class Main {
    public static Map<Book, String> placeByBook = new HashMap<>();

    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("Fahrenheit 451", "Ray Bradbury", 1953, "shelf-1");
        librarySystem.addBook("The Clean Coder", "Robert C. Martin", 2011, "shelf-19");
        librarySystem.addBook("Designing Data-Intensive Applications", "Martin Kleppmann", 2017, "shelf-8");
        librarySystem.addBook("Grokking Algorithms", "Aditya Bhargava", 2016, "shelf-2");

        System.out.println("-----------------------------------------------------");
        librarySystem.findBook("Fahrenheit 451", "Ray Bradbury", 1953);

        System.out.println("-----------------------------------------------------");
        System.out.println(librarySystem.removeBook("Fahrenheit 451", "Ray Bradbury", 1953));

        System.out.println("-----------------------------------------------------");
        librarySystem.printAllBooks();
    }

}
