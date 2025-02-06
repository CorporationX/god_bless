package school.faang;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        addMyBooks(librarySystem);
        librarySystem.printAllBook();
        System.out.println("-------------------------------");
        librarySystem.addBook("The Secret of the Enchanted Forest", "Lucia Storm", 2021, "D4E5C3");
        librarySystem.printAllBook();
        System.out.println("-------------------------------");
        librarySystem.removeBook("Mesmerizing School of Magic", "Emma Storm", 2003);
        librarySystem.printAllBook();
        System.out.println("-------------------------------");
        System.out.println("Book is in sector " + librarySystem.findBook("The Secret of the Enchanted Forest", "Lucia Storm", 2021));
    }

    private static void addMyBooks(LibrarySystem librarySystem) {
        librarySystem.addBook("The Secret of the Magic Rabbit", "Lewis Gray", 2001, "A1B2C3");
        librarySystem.addBook("Mesmerizing School of Magic", "Emma Storm", 2003, "D4E5F6");
        librarySystem.addBook("Twilight of Ancient Spells", "Dylan Frost", 2005, "G7H8I9");
        librarySystem.addBook("The Labyrinth of Lost Heroes", "Sophia Moon", 1999, "J0K1L2");
        librarySystem.addBook("Chronicles of the Enchanted Forest", "Thomas Williams", 2007, "M3N4O5");
    }
}