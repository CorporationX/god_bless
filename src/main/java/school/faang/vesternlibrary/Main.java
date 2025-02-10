package school.faang.vesternlibrary;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("Prestuplenie & Nakazanie", "Dostoevsky", 1866, "first shelf");
        librarySystem.addBook("Voina & Mir", "Tolstoy", 1867, "second shelf");
        librarySystem.addBook("Mertvie Dushi", "Gogol", 1842, "third shelf");
        try {
            librarySystem.addBook("", "", 0, "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("_________________________________");
        librarySystem.printAllBooks();
        System.out.println("_________________________________");

        librarySystem.removeBook("Prestyplenie & Nakazanie", "Dostaevski", 1866);
        try {
            librarySystem.removeBook("", "", 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("_________________________________");
        librarySystem.printAllBooks();
        System.out.println("_________________________________");

        librarySystem.findBook("Voina & Mir", "Tolstoy", 1867);


    }
}
