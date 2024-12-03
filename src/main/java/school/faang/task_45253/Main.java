package school.faang.task_45253;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        Map<Book, String> booksPlace = new HashMap<>(
                Map.of(
                        new Book("1984", "George Orwell", 1949), "A",
                        new Book("To Kill a Mockingbird", "Harper Lee", 1960), "B",
                        new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925), "C",
                        new Book("Pride and Prejudice", "Jane Austen", 1813), "D",
                        new Book("Moby-Dick", "Herman Melville", 1851), "E",
                        new Book("War and Peace", "Leo Tolstoy", 1869), "F"
                )
        );

        booksPlace.forEach(
                (k, v) -> librarySystem.addBook(k.getTitle(), k.getAuthor(), k.getYear(), v)
        );

        System.out.println("Before deleting 1984\n");
        librarySystem.printAllBooks();
        System.out.println(librarySystem.removeBook("1984", "George Orwell", 1949) + "\n");

        System.out.println("After deleting 1984\n");
        librarySystem.printAllBooks();
        librarySystem.addBook("1984", "George Orwell", 1949, "A");

        System.out.println("After adding 1984\n");
        librarySystem.printAllBooks();

        System.out.println("Where is the 1984?\n");
        System.out.println(librarySystem.findBook("1984", "George Orwell", 1949));
    }
}
