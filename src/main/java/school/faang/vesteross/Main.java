package school.faang.vesteross;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        LibrarySystem.printAllBooks();
        LibrarySystem.addBook("The Old Man and The Sea", "Ernest Hemingway", 1952, "#101");
        LibrarySystem.addBook("The Clean Coder", "Robert Martin", 2019, "#102");
        LibrarySystem.addBook("Levsha", "Nikolay Leskov", 1881, "#103");
        LibrarySystem.addBook("All the King's Men", "Robert Penn Warren", 1946, "#104");
        LibrarySystem.removeBook("Atomic Habits", "James Clear", 2018);
        LibrarySystem.findBook("The Clean Coder", "Robert Martin", 2019);
        LibrarySystem.findBook("Levsha", "Nikolay Leskov", 1981);
        LibrarySystem.printAllBooks();
    }

    public static class LibrarySystem {
        private static final String WARNING_MESSAGE = "There is no such book in the library";

        public static void addBook(String title, String author, int year, String libraryId) {
            library.put(new Book(title, author, year), libraryId);
        }

        public static void removeBook(String title, String author, int year) {
            if (library.remove(new Book(title, author, year)) != null) {
                System.out.println("The book was removed from the library");
            } else {
                System.out.println(WARNING_MESSAGE);
            }
        }

        public static void findBook(String title, String author, int year) {
            System.out.println(library.getOrDefault(new Book(title, author, year), WARNING_MESSAGE));
        }

        public static void printAllBooks() {
            if (library.isEmpty()) {
                System.out.println("The library has not any book!");
            } else {
                library.forEach((book, libId) -> System.out.println(libId + " " + book));
            }
        }
    }
}
