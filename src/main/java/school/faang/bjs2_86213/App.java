package school.faang.bjs2_86213;

public class App {
    public static void main(String[] args) {
        LibrarySystem.printAllBooks();

        LibrarySystem.addBook("War&Peace", "L.N.Tolstoy", 1869, "shelf 5");
        LibrarySystem.addBook("Crime and Punishment", "F. M. Dostoevsky", 1866, "shelf 2");
        LibrarySystem.addBook("Eugene Onegin", "A. S. Pushkin", 1833, "shelf 8");

        LibrarySystem.findBook("Crime and Punishment", "F. M. Dostoevsky", 1866);
        LibrarySystem.findBook("Crime and Punishment", "", 1866);
        LibrarySystem.findBook(null, "A. S. Pushkin", 1833);

        LibrarySystem.printAllBooks();

        LibrarySystem.removeBook("Eugene Onegin", "A. S. Pushkin", 1833);

        System.out.println("After remove");
        LibrarySystem.printAllBooks();
    }
}