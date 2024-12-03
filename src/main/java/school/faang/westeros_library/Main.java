package school.faang.westeros_library;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Book, String> books = new HashMap<>();
        books.put(new Book("Harry Potter", "K. Rowling", 1997), "303A");
        books.put(new Book("Harry Potter 2", "K. Rowling", 1999), "320B");
        books.put(new Book("Harry Potter 3", "K. Rowling", 2002), "156A");
        books.put(new Book("Harry Potter 4", "K. Rowling", 2003), "296A");

        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.setLibrary(books);
        librarySystem.printAllBooks();

        librarySystem.addBook("Harry Potter 5", "K. Rowling", 2005, "38A");
        librarySystem.removeBook("Harry Potter 2", "K. Rowling", 1999);
        librarySystem.findBook("Harry Potter 3", "K. Rowling", 2002);
        librarySystem.printAllBooks();

    }
}
