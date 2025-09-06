package school.faang.bjs2_86189;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        try {
            librarySystem.addBook("Las Vegas", "Jorg", 2003, "полка 1");
            librarySystem.addBook("Live in Vegas", "Jorg", 2005, "полка 2");
            librarySystem.addBook("Vegas", "Kennedy", 2000, "полка 3");
            librarySystem.addBook("JorgioMaccerati", "Jorg", 2005, "полка 4");
            librarySystem.addBook("LS", "Kramer", 2003, "полка 1");
            librarySystem.addBook("Liberty", "Dr.Krendel", 2009, "полка 5");
            librarySystem.addBook("JorgioMaccerati", "Jorg", 2005, "полка 7");
            librarySystem.removeBook("Vegas", "Kennedy", 2000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        librarySystem.findBook("Live in Vegas", "Jorg", 2005);
        librarySystem.printAllBooks();
    }
}
