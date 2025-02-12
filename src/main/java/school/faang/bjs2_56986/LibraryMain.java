package school.faang.bjs2_56986;

import java.util.HashMap;
import java.util.Map;

public class LibraryMain {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        Map<Book, String> library = new HashMap<>();


        librarySystem.addBook("Book1", "Author1", 1897, "Box1", library);
        librarySystem.addBook("Book2", "Author2", 1890, "Box2", library);
        librarySystem.addBook("Book3", "Author3", 1898, "Box3", library);
        librarySystem.printAllBooks(library);
        separator();

        librarySystem.removeBook("Book2", "Author2", 1890, library);
        librarySystem.findBook("Book2", "Author2", 1890, library);
        separator();

        librarySystem.findBook("Book1", "Author1", 1897, library);
        separator();
        librarySystem.printAllBooks(library);
    }

    private static void separator() {
        System.out.println("=====================================");
    }
}
