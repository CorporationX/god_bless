package school.faang.task_45353;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<>();
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("1984", "George Orwell", 1949, "Shelf 1");
        librarySystem.addBook("Fahrenheit 451", "Ray Bradbury", 1953, "Shelf 2");
        librarySystem.addBook("The Handmaid's Tale", "Margaret Atwood", 1985, "Shelf 3");

        librarySystem.findBook("1984", "George Orwell", 1949);
        librarySystem.findBook("Dune", "Frank Herbert", 1965);

        librarySystem.removeBook("Fahrenheit 451", "Ray Bradbury", 1953);
        librarySystem.findBook("Fahrenheit 451", "Ray Bradbury", 1953);

        librarySystem.printAllBooks();
    }

}
