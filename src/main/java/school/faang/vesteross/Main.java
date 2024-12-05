package school.faang.vesteross;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.printAllBooks();

        librarySystem.addBook("The Old Man and The Sea", "Ernest Hemingway", 1952, "#101");
        librarySystem.addBook("The Clean Coder", "Robert Martin", 2019, "#102");
        librarySystem.addBook("Levsha", "Nikolay Leskov", 1881, "#103");
        librarySystem.addBook("All the King's Men", "Robert Penn Warren", 1946, "#104");

        librarySystem.removeBook("Atomic Habits", "James Clear", 2018);
        librarySystem.removeBook("The Old Man and The Sea", "Ernest Hemingway", 1952);
        librarySystem.findBook("The Clean Coder", "Robert Martin", 2019);
        librarySystem.findBook("Levsha", "Nikolay Leskov", 1981);

        librarySystem.printAllBooks();
    }
}
