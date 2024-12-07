package school.faang.task_45328;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> LIBRARY = new HashMap<>();

    public static void main(String[] args) {
        Book book1 = new Book("1984", "George Orwell", 1949);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);

        LIBRARY.put(book1, "Shelf A1");
        LIBRARY.put(book2, "Shelf B2");
        LIBRARY.put(book3, "Shelf C3");

        LibrarySystem librarySystem = new LibrarySystem(LIBRARY);

        librarySystem.addBook("Moby Dick", "Herman Melville", 1851, "Shelf D4");
        librarySystem.printAllBooks();

        librarySystem.removeBook("To Kill a Mockingbird", "Harper Lee", 1960);
        librarySystem.printAllBooks();

        librarySystem.findBook("The Great Gatsby", "F. Scott Fitzgerald", 1925);
    }

}
