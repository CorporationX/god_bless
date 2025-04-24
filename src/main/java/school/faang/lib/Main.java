package school.faang.lib;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Hunger Games", "smb", 2023, "5th shelf");
        librarySystem.addBook("Hunger Games 2", "smb 2", 2022, "6th shelf");
        librarySystem.addBook("Hunger Games 3", "smb 3", 2013, "7th shelf");
        librarySystem.addBook("Hunger Games 4", "smb 4", 2020, "8th shelf");

        System.out.println(librarySystem.findBook("Hunger Games 4", "smb 4", 2020));
        librarySystem.removeBook("Hunger Games 4", "smb 4", 2020);
        librarySystem.printAllBooks();
    }
}
