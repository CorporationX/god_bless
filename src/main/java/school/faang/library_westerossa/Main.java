package school.faang.library_westerossa;

public class Main {

    public static void main(String[] args) {

        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("1", "who", 1990, "a");
        librarySystem.addBook("2", "j", 1991, "b");
        librarySystem.addBook("3", "l", 1992, "c");
        librarySystem.addBook("4", "b", 1993, "d");
        librarySystem.addBook("5", "m", 1994, "e");
        librarySystem.addBook("6", "q", 1995, "f");
        librarySystem.addBook("7", "p", 1996, "g");
        librarySystem.addBook("8", "z", 1997, "h");

        librarySystem.findBook("3", "l", 1992);

        librarySystem.removeBook("7", "p", 1996);

        librarySystem.printAllBooks();
    }
}
