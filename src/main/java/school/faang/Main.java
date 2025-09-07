package school.faang;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        library.addBook("Dune", "Frank Herbert", 1965, "123");
        library.addBook("Clean Code", "Robert Martin", 2008, "345");

        library.printAllBooks();

        String duneLoc = library.findBook("Dune", "Frank Herbert", 1965);
        System.out.println("Dune location: " + duneLoc);

        library.removeBook("Clean Code", "Robert Martin", 2008);
        library.printAllBooks();

        try {
            library.findBook("Clean Code", "Robert Martin", 2008);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

    }
}
