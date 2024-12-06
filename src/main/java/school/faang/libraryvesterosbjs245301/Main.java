package school.faang.libraryvesterosbjs245301;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        library.addBook("Annals of the Black Centaur", "Yorkwen", 12, "Shelf A1");
        library.addBook("The Red Book", "Elkin", 79, "Shelf A2");
        library.addBook("Flora of the Valyrian Freehold", "Mikellion", 36, "Shelf A3");

        library.printAllBooks();
        library.findBook("The Red Book", "Elkin", 79);
        library.removeBook("The Red Book", "Elkin", 79);
        library.printAllBooks();

    }
}
