package school.faang.westeroslibrary.main;

import school.faang.westeroslibrary.service.LibrarySystem;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem(new HashMap<>());
        librarySystem.addBook("The Hobbit", "J.R.R. Tolkien", 1937, "Shelf A3");
        librarySystem.addBook("1984", "George Orwell", 1949, "Shelf B1");
        librarySystem.addBook("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997, "Shelf C2");
        librarySystem.printAllBooks();
        librarySystem.findBook("The Hobbit", "J.R.R. Tolkien", 1937);
        librarySystem.findBook("Brave New World", "Aldous Huxley", 1932);
        librarySystem.removeBook("1984", "George Orwell", 1949);
        librarySystem.printAllBooks();
    }
}