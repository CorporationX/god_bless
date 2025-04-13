package school.faang.westуros_library;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("The Hobbit", "J.R.R. Tolkien", 1937, "Shelf 1");
        librarySystem.addBook("1984", "George Orwell", 1949, "Shelf 2");
        librarySystem.addBook("Moby Dick", "Herman Melville", 1851, "Shelf 3");

        System.out.println("All books in the library:");
        librarySystem.printAllBooks();

        System.out.println("\nFinding book '1984':");
        librarySystem.findBook("1984", "George Orwell", 1949);

        System.out.println("\nRemoving book 'Moby Dick':");
        librarySystem.removeBook("Moby Dick", "Herman Melville", 1851);

        System.out.println("\nAll books in the library after removal:");
        librarySystem.printAllBooks();

        System.out.println("\nTrying to remove a non-existent book:");
        librarySystem.removeBook("The Catcher in the Rye", "J.D. Salinger", 1951);
    }
}