package school.faang.module1.task45273;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static LibrarySystem librarySystem = new LibrarySystem();
    static Map<Book, String> bookLocation = new HashMap<>();

    public static void main(String[] args) {

        Book book1 = new Book("Harry Potter and the Prisoner of Azkaban", "JK Rowling", 2000);
        Book book2 = new Book("The Green Mile", "Stephen King", 1993);
        Book book3 = new Book("The Lord of the Rings: The Return of the King", "John R. R. Tolkien", 1950);

        bookLocation.put(book1, "shelf1");
        bookLocation.put(book2, "shelf2");
        bookLocation.put(book3, "shelf1");

        librarySystem.printAllBooks();
        librarySystem.removeBook("Harry Potter and the Prisoner of Azkaban", "JK Rowling", 2000);
        librarySystem.printAllBooks();
        librarySystem.addBook("The Count of Monte Cristo", "Alexandre Dumas", 1700, "shelf4");
        librarySystem.printAllBooks();
        librarySystem.findBook("The Lord of the Rings: The Return of the King", "John R. R. Tolkien", 1950);
    }


}
