package school.faang.libraryofvesteros;

public class Main {
    public static void main(String[] args) {
        try {
            LibrarySystem gorkyLibrary = new LibrarySystem();

            gorkyLibrary.printAllBooks();

            gorkyLibrary.addBook(
                    "Harry Potter and the Philosopher's Stone", "Joan Rowling", 1997, "1a");
            gorkyLibrary.addBook(
                    "Harry Potter and the Chamber of Secrets", "Joan Rowling", 1998, "2a");
            gorkyLibrary.addBook(
                    "Harry Potter and the Prisoner of Azkaban", "Joan Rowling", 1999, "3a");
            gorkyLibrary.addBook(
                    "Harry Potter and the Goblet of Fire", "Joan Rowling", 2000, "4a");
            gorkyLibrary.addBook(
                    "Harry Potter and the Order of the Phoenix", "Joan Rowling", 2003, "1b");
            gorkyLibrary.addBook(
                    "Harry Potter and the Half-Blood Prince", "Joan Rowling", 2005, "2b");
            gorkyLibrary.addBook(
                    "Harry Potter and the Deathly Hallows", "Joan Rowling", 2007, "3b");
            gorkyLibrary.addBook(
                    "Another Harry Potter", "Joan Rowling", 2007, "4b");
            gorkyLibrary.addBook(
                    "My tested book", "Maxim Goloviznin", 2007, "1c");
            gorkyLibrary.printAllBooks();

            gorkyLibrary.removeBook("Another Harry Potter", "Joan Rowling", 2007);
            gorkyLibrary.removeBook("Harry Potter and the Philosopher's Stone", "Joan Rowling", 1997);
            gorkyLibrary.removeBook("Harry Potter and the Goblet of Fire", "Joan Rowling", 2000);
            gorkyLibrary.removeBook("Harry Potter and the Order of the Phoenix", "Joan Rowling", 2003);
            gorkyLibrary.printAllBooks();

            gorkyLibrary.findBook("My tested book", "Maxim Goloviznin", 2007);
            gorkyLibrary.findBook("Another Harry Potter", "Joan Rowling", 2007);
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}
