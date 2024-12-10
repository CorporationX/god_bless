package school.faang.bjs245323;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> shelf = new HashMap<>();

        shelf.put(new Book("Steve Jobs", "Steve Jobs", 2015), "1");
        shelf.put(new Book("Master Your Feelings", "Eric Robertson", 2019), "1");

        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Steve Jobs", "Steve Jobs", 2015, "1");
        librarySystem.addBook("Master Your Feelings", "Eric Robertson", 2019, "1");
        librarySystem.addBook("Fear no evil", "Random House", 1988, "2");
        librarySystem.addBook("Her mother's face", "Arthur A. Levine Books", 2008, "2");
        librarySystem.removeBook("Master Your Feelings", "Eric Robertson", 2019);
        librarySystem.findBook("Steve Jobs", "Steve Jobs", 2015);
        librarySystem.printAllBook();
    }
}
