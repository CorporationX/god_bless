package school.faang.library_vesteros_bjs2_45301;

import java.util.HashMap;
import java.util.Map;

public class Main {
    protected static Map<Book, String> numberShelf = new HashMap<>();

    public static void main(String[] args) {

        LibrarySystem.addBook("Annals of the Black Centaur", "Yorkwen", 12, "Shelf A1");
        LibrarySystem.addBook("The Red Book", "Elkin", 79, "Shelf A2");
        LibrarySystem.addBook("Flora of the Valyrian Freehold", "Mikellion", 36, "Shelf A3");

        LibrarySystem.printAllBooks();
        LibrarySystem.findBook("The Red Book", "Elkin", 79);
        LibrarySystem.removeBook("The Red Book", "Elkin", 79);
        LibrarySystem.printAllBooks();

    }
}
