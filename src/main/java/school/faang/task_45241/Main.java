package school.faang.task_45241;

import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<>();
        library.put(new Book("Journey", "Peter Red", 2015), "Table");
        library.put(new Book("Thriller", "Alina Won", 1999), "Chair");
        library.put(new Book("Comedy", "Hong", 2010), "Floor");

        LibrarySystem librarySystem = new LibrarySystem(library);

        librarySystem.addBook("Drama", "Frank", 2019, "Paris");
        System.out.println("After add: " + librarySystem.getLibrary());

        librarySystem.removeBook("Journey", "Peter Red", 2015);
        System.out.println("After remove: " + librarySystem.getLibrary());

        String location = librarySystem.findBook("Thriller", "Alina Won", 1999);
        System.out.println("After find: " + location);

        System.out.println("Print all:");
        librarySystem.printAllBooks();
    }
}
