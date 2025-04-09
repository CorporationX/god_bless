package school.faang.bjs2_68674;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("title1", "author1", 2025, "location1");
        librarySystem.addBook("title2", "author2", 2024, "location2");
        librarySystem.addBook("title3", "author3", 2023, "location3");
        librarySystem.addBook("title4", "author4", 2022, "location4");
        librarySystem.removeBook("title1", "author1", 2025);
        librarySystem.findBook("title2", "author2", 2024);
        librarySystem.printAllBooks();
    }
}