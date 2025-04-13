package school.faang.bjs2_68734;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        // Adding books
        library.addBook("1984", "George Orwell", 1949, "Shelf A1");
        library.addBook("War and Peace", "Leo Tolstoy", 1869, "Shelf B2");
        library.addBook("The Hobbit", "J.R.R. Tolkien", 1937, "Shelf C3");

        // Finding books
        log.info(library.findBook("1984", "George Orwell", 1949));
        log.info(library.findBook("Unknown", "Nobody", 2000));

        // Removing a book
        boolean removed = library.removeBook("The Hobbit", "J.R.R. Tolkien", 1937);
        log.info("Was 'The Hobbit' removed? {}", removed);

        // Removing a book that doesn't exist
        boolean removedUnknown = library.removeBook("Dune", "Frank Herbert", 1965);
        log.info("Was 'Dune' removed? {}", removedUnknown);

        // Listing all remaining books
        log.info("Remaining books in the library:");
        library.printAllBooks();
    }

}
