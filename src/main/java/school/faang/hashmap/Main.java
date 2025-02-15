package school.faang.hashmap;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Harry Potter and the Philosopher’s Stone", "J.K. Rowling", 1997, "Shelf 1");
        librarySystem.addBook("1984", "George Orwell", 1949, "Shelf 2");
        librarySystem.addBook("The Master and Margarita", "Mikhail Bulgakov", 1967, "Shelf 3");

        librarySystem.printAllBooks();

        librarySystem.findBook("Harry Potter and the Philosopher’s Stone", "J.K. Rowling", 1997);

        librarySystem.removeBook("1984", "George Orwell", 1949);

        librarySystem.printAllBooks();
    }
}

