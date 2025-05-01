package westeros.biblioteque;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("War and Peace", "Lev Tolstoi", 1867, "Shelf no:1");
        librarySystem.addBook("1984", "George Orwell", 1949, "Shelf no:2");
        librarySystem.addBook("Shogun", "James Clavell", 1975, "Shelf no:3");
        librarySystem.addBook("Dune", "Frank Herbert", 1965, "Shelf no:4");

        System.out.println("After add");
        librarySystem.printAllBooks();

        librarySystem.removeBook("War and Peace", "Lev Tolstoi", 1867);

        System.out.println();
        System.out.println("After remove");
        librarySystem.printAllBooks();

        System.out.println();
        System.out.println("Find the book");
        librarySystem.findBook("Dune", "Frank Herbert", 1965);
        System.out.println();
    }
}
