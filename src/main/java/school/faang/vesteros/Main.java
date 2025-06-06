package school.faang.vesteros;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public class Main {

    public static void main(String[] args) {
        LibrarySystem.addBook("Book 1", "Author 1", 1970, "Location 1");
        LibrarySystem.addBook("Book 2", "Author 2", 1971, "Location 2");
        LibrarySystem.addBook("Book 3", "Author 3", 1972, "Location 3");
        LibrarySystem.addBook("Book 4", "Author 4", 1973, "Location 4");

        LibrarySystem.removeBook("Book 4", "Author 4", 1973);

        var location = LibrarySystem.findBook("Book 3", "Author 3", 1972);
        System.out.println("Book 3: " + location + "\n");

        LibrarySystem.printBooks();
    }
}
