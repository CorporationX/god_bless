package school.faang;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        HashMap<Book, String> theLocationOfTheBook = new HashMap<>();

        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Book book2 = new Book("Moby-Dick", "Herman Melville", 1851);

        theLocationOfTheBook.put(book1, "The seventh regiment");
        theLocationOfTheBook.put(book2, "The tenth regiment");

        LibrarySystem librarySystem = new LibrarySystem(theLocationOfTheBook);

        librarySystem.printAllBooks();

        librarySystem.addBook("Nine Seven", "George Orwell", 1949, "Third regiment");
        librarySystem.addBook("To Kill a Mockingbird", "Harper Lee", 1960, "The fifth regiment");

        librarySystem.printAllBooks();

        librarySystem.removeBook("To Kill a Mockingbird", "Harper Lee", 1960);
        librarySystem.removeBook("Unknown book", "Harper Lee", 1960);

        librarySystem.printAllBooks();

        librarySystem.findBook("Nine Seven", "George Orwell", 1949);
        librarySystem.findBook("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        librarySystem.findBook("The Great Gatsby", "F. Scott Fitzgerald", 1900);

    }
}
