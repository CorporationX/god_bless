package gratsio_BJS2_68664;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("War and Peace", "Tolstoy L.N.", 1867);
        Book book2 = new Book("The Master and Margarita", "Bulgakov M.A.", 1967);
        Book book3 = new Book("Three comrades", "Remark E.M.", 1936);
        Book book4 = new Book("Doctor Zhivago", "Pasternak B.L.", 1957);
        Book book5 = new Book("Ruy Blas", "Hugo V.M.", 1967);

        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("The Master and Margarita", "Bulgakov M.A.", 1967, "A shelf with novels");
        librarySystem.addBook("War and Peace", "Tolstoy L.N.", 1867, "The novel cabinet");
        librarySystem.addBook("Three comrades", "Remark E.M.", 1936, "The central cabinet with novels");
        librarySystem.addBook("Doctor Zhivago", "Pasternak B.L.", 1957, "The section with novels");
        librarySystem.addBook("Ruy Blas", "Hugo V.M.", 1967, "A shelf with books of the drama genre");

        librarySystem.findBook("War and Peace", "Tolstoy L.N.", 1867);
        librarySystem.removeBook("War and Peace", "Tolstoy L.N.", 1867);
        librarySystem.findBook("War and Peace", "Tolstoy L.N.", 1867);

        librarySystem.printAllBooks();

    }
}
