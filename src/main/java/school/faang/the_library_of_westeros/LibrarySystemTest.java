package school.faang.the_library_of_westeros;

public class LibrarySystemTest {
    public static void main(String[] args) {
        LibrarySystem libraryTest = new LibrarySystem();
        libraryTest.addBook("TT1", "Unknown", 477, "black turet");
        libraryTest.addBook("TT2", "Unknown", 479, "pirat bich");
        libraryTest.addBook("TT3", "Unknown", 480, "red hause");
        libraryTest.addBook("TT4", "Unknown", 482, "black turet");
        libraryTest.removeBook("TT2", "Unknown", 479);
        libraryTest.findBook("TT3", "Unknown", 480);
        libraryTest.findBook("TT5", "Unknown", 485);
        libraryTest.printAllBooks();
    }
}
