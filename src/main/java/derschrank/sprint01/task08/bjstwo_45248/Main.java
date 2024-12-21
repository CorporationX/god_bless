package derschrank.sprint01.task08.bjstwo_45248;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Book1", "Author1", 2024, "Polka1");
        librarySystem.addBook("Book2", "Author2", 2024, "Polka2");

        Book bookX1 = new Book("BookX1", "AuthorX1", 2024);
        librarySystem.addBook(bookX1, "Polka3");
        librarySystem.addBook("BookX2", "AuthorX2", 2024, "Polka2");

        librarySystem.printAllBooks();


        Book bookX2 = new Book("BookX2", "AuthorX2", 2024);
        System.out.println("Looking for " + bookX1 + ", it is located at: "
                + librarySystem.findBook(bookX1));
        System.out.println("Looking for " + bookX2 + ", it is located at: "
                + librarySystem.findBook(bookX2));
        Book bookUnknow = new Book("Unknown", "-", 2000);
        System.out.println("Looking for " + bookUnknow + ", it is located at: "
                + librarySystem.findBook(bookUnknow));

        System.out.println("Deleting " + bookX1 + " and " + bookX2 + " ...\n");
        librarySystem.removeBook(bookX1);
        librarySystem.removeBook(bookX2);
        librarySystem.removeBook(bookUnknow);

        librarySystem.printAllBooks();

    }
}
