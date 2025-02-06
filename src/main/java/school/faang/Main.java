package school.faang;


public class Main {
    public static void main(String[] args) {

        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("Third book", "Anna Korenena", 1911, "3 полка по цетнру");
        librarySystem.addBook("First book", "Ilya Yanchenko", 1999, "2 полка снизу слева");
        librarySystem.addBook("Second book", "Not Ilya Yanchenko", 1900, "1 полка сверху справа");

        librarySystem.findBook("First book", "Ilya Yanchenko", 1999);

        librarySystem.printAllBooks();

        librarySystem.removeBook("Second book", "Not Ilya Yanchenko", 1900);
        librarySystem.removeBook("First book", "Ilya Yanchenko", 1999);

        librarySystem.printAllBooks();

    }
}
