package school.faang.bjs2_86182;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Book, String> library = new HashMap<>();
        LibrarySystem system = new LibrarySystem(library);

        system.addBook("Atomic Habits", "James Clear", 2024, "Shelf A");
        system.addBook("The Alchemist", "Paulo Coelho", 1988, "Shelf B");

        system.removeBook("The Alchemist", "Paulo Coelho", 1988);
        system.findBook("Atomic Habits", "James Clear", 2024);
        system.printAllBooks();
    }
}
