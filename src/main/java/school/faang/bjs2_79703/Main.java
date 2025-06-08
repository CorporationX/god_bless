package school.faang.bjs2_79703;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> libraryMap = new HashMap<>() {
            {
                put(new Book("1", "1", 1), "1");
                put(new Book("2", "2", 2), "2");
                put(new Book("3", "3", 3), "3");
                put(new Book("4", "4", 4), "4");
            }
        };

        LibrarySystem librarySystem = new LibrarySystem(libraryMap);

        librarySystem.addBook("5", "5", 5, "5");
        System.out.println(librarySystem.removeBook("3", "3", 3));
        System.out.println(librarySystem.findBook("2", "2", 2));
        librarySystem.printAllBooks();
    }
}