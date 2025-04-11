package school.faang.library;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem(new HashMap<>());
        librarySystem.addBook("History", "Old one", 1990, "Номер 1");
        librarySystem.addBook("Math", "Smart one", 90, "Номер 2");
        librarySystem.addBook("Physics", "Newton", 1700, "Номер 1");
        librarySystem.addBook("War and piece", "Tolstoy", 1867, "Номер 2");
        librarySystem.addBook("History", "Old one", 1990, "Номер 2");
        librarySystem.addBook("English", "English one", 2010, "Номер 1");
        librarySystem.addBook("Russian", "Russian one", 1999, "Номер 3");

        librarySystem.printAllBooks();

        librarySystem.removeBook("History", "Old one", 1990);
        librarySystem.removeBook("History", "Old one", 1990);

        librarySystem.printAllBooks();

        librarySystem.findBook("English", "English one", 2010);
        librarySystem.findBook("History", "Old one", 1990);
    }
}
