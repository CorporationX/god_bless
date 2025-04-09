package school.faang.bjs2_68700;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("book1", "author1", 1996, "1");
        librarySystem.addBook("book2", "author2", 1998, "2");
        librarySystem.addBook("book3", "author3", 1968, "3");
        librarySystem.addBook("book4", "author4", 1956, "2");
        librarySystem.addBook("book5", "author5", 1977, "3");

        System.out.println("Books list:");
        librarySystem.printAllBooks();

        librarySystem.removeBook("book3", "author3", 1967);
        librarySystem.removeBook("book3", "author3", 1968);

        System.out.println("Books list after delete:");
        librarySystem.printAllBooks();

        System.out.println("\nFind book:");
        System.out.println(librarySystem.findBook("book3", "author3", 1968));

        System.out.println("\nFind book:");
        System.out.printf(librarySystem.findBook("book5", "author5", 1977));
    }
}