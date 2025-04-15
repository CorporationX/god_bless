package school.faang.westeros_library;

public class TestLibrary {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Total", "Borodin", 2020, "First shelf");
        librarySystem.addBook("Byble", "Jesus", 23, "First shelf");
        librarySystem.addBook("Barbie", "Borodin", 2120, "Table");
        librarySystem.addBook("Total", "Borodin", 2020, "Table");

        System.out.println(librarySystem.findBook("Total", "Borodin", 2020));

        librarySystem.removeBook("Total", "Borodin", 2020);

        System.out.println(librarySystem.printAllBooks());
    }
}
