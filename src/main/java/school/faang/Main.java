package school.faang;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Can't hurt me", "David Goggins", 2018, "left");
        librarySystem.addBook("Atomic Habits", "James Clear", 2018, "right");
        librarySystem.findBook("Getting things done", "David Allen", 1922);
        librarySystem.removeBook("Atomic Habits", "James Clear", 2018);
        librarySystem.printAllBooks();
    }
}
