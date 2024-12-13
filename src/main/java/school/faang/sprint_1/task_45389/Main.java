package school.faang.sprint_1.task_45389;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("The Lord of the Rings", "J.Tolkien", 1954, "l-11");
        librarySystem.addBook("Harry Potter and the Philosopher's Stone", "J.Rowling", 1997, "h-13");
        librarySystem.addBook("A Game of Thrones", "R.Martin", 1996, "g-32");
        librarySystem.addBook("War and Piece", "L.Tolstoy", 1867, "l-54");
        librarySystem.addBook("The Three Musketeers", "A.Dumas", 1844, "d-11");
        librarySystem.addBook("An American Tragedy", "T.Dreiser", 1925, "d-25");
        librarySystem.removeBook("Harry Potter and the Philosopher's Stone", "J.Rowling", 1997);
        librarySystem.findBook("Harry Potter and the Philosopher's Stone", "J.Rowling", 1999);
        librarySystem.findBook("War and Piece", "L.Tolstoy", 1867);
        librarySystem.printAllBooks();
    }
}
