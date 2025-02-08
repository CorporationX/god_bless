package school.faang.vesternlibrary;

public class Main {
    public static void main(String[] args) {

        LibrarySystem.addBook("Prestyplenie & Nakazanie", "Dostaevski", 1866, "first shelf");
        LibrarySystem.addBook("Voina & Mir", "Tolstoy", 1867, "second shelf");
        LibrarySystem.addBook("Mertvie Dyshi", "Gogol", 1842, "third shelf");
        try {
            LibrarySystem.addBook("", "", 0, "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("_________________________________");
        LibrarySystem.printAllBooks();
        System.out.println("_________________________________");

        LibrarySystem.removeBook("Prestyplenie & Nakazanie", "Dostaevski", 1866);
        try {
            LibrarySystem.removeBook("", "", 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("_________________________________");
        LibrarySystem.printAllBooks();
        System.out.println("_________________________________");

        LibrarySystem.findBook("Voina & Mir", "Tolstoy", 1867);



    }
}
