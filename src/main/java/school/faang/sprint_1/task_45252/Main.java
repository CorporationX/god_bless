package school.faang.sprint_1.task_45252;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final Map<Book, String> LIBRARY = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Adding books to Library...");
        LibrarySystem.addBook("Book 1", "Author 1", 2001, "Location 1");
        LibrarySystem.addBook("Book 2", "Author 2", 2002, "Location 2");
        LibrarySystem.addBook("Book 3", "Author 3", 2003, "Location 3");
        LibrarySystem.printAllBooks();

        System.out.println("Removing Book 2 from Library...");
        LibrarySystem.removeBook("Book 2", "Author 2", 2002);
        LibrarySystem.printAllBooks();

        System.out.println("Finding Book 3 from Library...");
        LibrarySystem.findBook("Book 3", "Author 3", 2003);
        LibrarySystem.printAllBooks();
    }
}
