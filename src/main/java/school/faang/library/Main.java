package school.faang.library;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("New Harry Potter", "Amanzhol", 2025, "first place");
        librarySystem.findBook("New Harry Potter", "Amanzhol", 2025);
        librarySystem.findBook("Old Harry Potter", "Amanzhol", 2025);
        librarySystem.removeBook("New Harry Potter", "Amanzhol", 2025);
        librarySystem.findBook("New Harry Potter", "Amanzhol", 2025);
        librarySystem.addBook("New Harry Potter", "Amanzhol", 2025, "first place");
        librarySystem.addBook("The school", "Mikhail", 1980, "second place");
        librarySystem.addBook("The University", "Oleg", 2020, "first place");
        librarySystem.addBook("The University", "Oleg", 2020, "second place");
        librarySystem.printAllBooks();
    }
}
