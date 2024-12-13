package school.faang.task_45408;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<Book, String> bookShelveInfo = new HashMap<>();

    public static void main(String[] args) {
        Book firstBook = new Book("Fahrenheit 451", "Ray Bradbury", 1953);
        Book secondBook = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        bookShelveInfo.put(firstBook, "firstShelve");
        bookShelveInfo.put(secondBook, "secondShelve");

        System.out.println(LibrarySystem.findBook("Fahrenheit 451", "Ray Bradbury", 1953));
        System.out.println(LibrarySystem.findBook("Fahrenheit 451", "Ray Bradbury", 1952));

        LibrarySystem.addBook("Moby-Dick", "Herman Melville", 1851, "firstShelve");
        LibrarySystem.removeBook("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        LibrarySystem.removeBook("To Kill a Mockingbird", "Harper Lee", 1960);

        LibrarySystem.printAllBooks();

    }
}
