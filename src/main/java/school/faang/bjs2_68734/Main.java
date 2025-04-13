package school.faang.bjs2_68734;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        // Adding books
        library.addBook("1984", "George Orwell", 1949, "Shelf A1");
        library.addBook("War and Peace", "Leo Tolstoy", 1869, "Shelf B2");
        library.addBook("The Hobbit", "J.R.R. Tolkien", 1937, "Shelf C3");

        // Finding books
        System.out.println(library.findBook("1984", "George Orwell", 1949));
        System.out.println(library.findBook("Unknown", "Nobody", 2000));

        // Removing a book
        boolean removed = library.removeBook("The Hobbit", "J.R.R. Tolkien", 1937);
        System.out.println("Was 'The Hobbit' removed? " + removed);

        // Removing a book that doesn't exist
        boolean removedUnknown = library.removeBook("Dune", "Frank Herbert", 1965);
        System.out.println("Was 'Dune' removed? " + removedUnknown);

        // Listing all remaining books
        System.out.println("Remaining books in the library:");
        library.printAllBooks();
    }

}
