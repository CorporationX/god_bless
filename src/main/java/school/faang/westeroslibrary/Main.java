package school.faang.westeroslibrary;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Book1", "Martin", 1996, "Shelf 1");
        librarySystem.addBook("Book3", "Doe", 1999, "Shelf 3");
        librarySystem.addBook("Book4", "James", 2001, "Shelf 11");
        librarySystem.findBook("Book2", "Martin", 1998);
        librarySystem.addBook("Book2", "Martin", 1998, "Shelf 2");
        librarySystem.findBook("Book2", "Martin", 1998);
        librarySystem.removeBook("The Hobbit", "Tolkien", 1937);
        librarySystem.removeBook("Book2", "Martin", 1998);
        librarySystem.printAllBooks();
    }
}
