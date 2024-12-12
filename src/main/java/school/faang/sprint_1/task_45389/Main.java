package school.faang.sprint_1.task_45389;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {
        books.put(new Book("The Lord of the Rings", "J.Tolkien", 1954), "l-11");
        books.put(new Book("Harry Potter and the Philosopher's Stone", "J.Rowling", 1997), "h-13");
        books.put(new Book("A Game of Thrones", "R.Martin", 1996), "g-32");
        books.put(new Book("War and Piece", "L.Tolstoy", 1867), "l-54");
        books.put(new Book("The Three Musketeers", "A.Dumas", 1844), "d-11");

        LibrarySystem.addBook("An American Tragedy", "T.Dreiser", 1925, "d-25");
        LibrarySystem.removeBook("Harry Potter and the Philosopher's Stone", "J.Rowling", 1997);
        LibrarySystem.findBook("Harry Potter and the Chamber of Secrets", "J.Rowling", 1999);
        LibrarySystem.findBook("War and Piece", "L.Tolstoy", 1867);
        LibrarySystem.printAllBooks();
    }
}
