package school.faang.bjs2_86153;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("History of world", "Marsel", 3, "shelf 1");
        librarySystem.addBook("Math of world", "Alan", 2, "shelf 2");
        librarySystem.addBook("Biological of world", "Mark", 4, "shelf 3");
        librarySystem.addBook("Physics of world", "Septi", 5, "shelf 4");

        librarySystem.removeBook("History of world", "Marsel", 3);

        librarySystem.findBook("Math of world", "Alan", 2);

        librarySystem.printAllBooks();
    }
}
