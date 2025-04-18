package faang.school.library;

public class Main {
    public static void main(String[] args) {

        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Martin Eden", "Jack London", 1909, "first shelf");
        librarySystem.addBook("1984", "George  George ", 1949, "second shelf");
        librarySystem.addBook("Three Comrades ", "Remarque", 1936, "third shelf");
        librarySystem.addBook("The night in Lisbon", "Remarque ", 1962, "third shelf");
        librarySystem.addBook("The Count of Monte Cristo", "Alexander Dumas", 1844, "sixth shelf");
        librarySystem.addBook("The three musketeers", "Alexander Dumas", 1844, "sixth shelf");
        librarySystem.addBook("The Count of Monte Cristo", "Alexander Dumas", 1844, "sixth shelf");

        System.out.println("The list of all books in this library");
        librarySystem.printAllBooks();
        librarySystem.findBook("The Count of Monte Cristo", "Alexander Dumas", 1844);
        librarySystem.removeBook("The Count of Monte Cristo", "Alexander Dumas", 1844);
        librarySystem.findBook("The night in Lisbon", "Remarque ", 1962);
        librarySystem.removeBook("Martin Eden", "Jack London", 1909);
        librarySystem.printAllBooks();
    }
}
