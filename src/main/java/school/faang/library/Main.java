package school.faang.library;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("t1", "a1", 2025, "shelf1");
        librarySystem.addBook("t2", "a2", 2025, "shelf2");
        librarySystem.addBook("t3", "a3", 2025, "shelf3");

        librarySystem.removeBook("t1", "a1", 2025);

        librarySystem.findBook("t1", "a1", 2025);

        librarySystem.printAllBooks();
    }
}
