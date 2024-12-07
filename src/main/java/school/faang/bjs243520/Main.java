package school.faang.bjs243520;

public class Main {

    public static void main(String[] args) {

        LibrarySystem library = new LibrarySystem();
        library.addBook("Title1", "Author1", 1990, "Library1");
        library.addBook("Title2", "Author2", 2010, "Library1");
        library.addBook("Title3", "Author3", 1900, "Library2");
        library.addBook("Title4", "Author4", 2020, "Library2");
        library.addBook("Title5", "Author1", 2005, "Library2");

        library.findBook("Title3", "Author3", 1900);

        library.removeBook("Title3", "Author3", 1900);

        library.printAllBooks();
    }
}
