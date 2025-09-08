package school.faang.bjs286024;

public class Main {

    public static void main(String[] args) {

        LibrarySystem.addBook("Name1", "Author1", 2001, "Level A");
        LibrarySystem.addBook("Name2", "Author2", 2022, "Level B");
        LibrarySystem.addBook("Name3", "Author3", 1990, "Level C");

        LibrarySystem.printAllBooks();
        LibrarySystem.removeBook("Name1", "Author1", 2001);
        LibrarySystem.findBook("Name2", "Author2", 2022);
        LibrarySystem.findBook("Name1", "Author1", 2001);
        LibrarySystem.printAllBooks();
    }
}
