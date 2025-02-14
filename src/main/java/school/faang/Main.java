package school.faang;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("War and peace", "Tolstoy", 1867, "Shelf 1");
        librarySystem.addBook("Harry Potter", "Rouling", 2000, "Shelf 3");
        librarySystem.addBook("Martin Iden", "London", 1900, "Shelf 5");

        librarySystem.findBook("Martin Iden", "London", 1900);

        librarySystem.printAllBooks();

        librarySystem.removeBook("Martin Iden", "London", 1900);

        librarySystem.printAllBooks();
    }
}
