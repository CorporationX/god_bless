package school.faang;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        initLibrary(librarySystem);
        librarySystem.printAll();

        Book foundBook = librarySystem.find("Something1", "Alexandrov", 2002);
        System.out.println("\n" + foundBook + "\n");

        librarySystem.remove("Something1", "Alexandrov", 2002);
        librarySystem.printAll();
    }

    private static void initLibrary(LibrarySystem librarySystem) {
        librarySystem.add("Something1", "Akhadov", 2002, "Shelf 1");
        librarySystem.add("Something2", "Kirillov", 2002, "Shelf 1");
        librarySystem.add("Something3", "Mishanov", 2002, "Shelf 1");
        librarySystem.add("Something1", "Alexandrov", 2002, "Shelf 1");
    }
}
