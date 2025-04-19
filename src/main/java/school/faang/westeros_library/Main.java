package school.faang.westeros_library;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        library.addBook("1984", "George Orwell", 1949, "Zone A, Shelf 2");
        library.addBook("To Kill a Mockingbird", "Harper Lee", 1960, "Zone D, Shelf 4");
        library.addBook("Pride and Prejudice", "Jane Austen", 1813, "Zone E, Shelf 2");

        library.printAllBooks();

        library.findBook("1984", "George Orwell", 1949);
        library.findBook("To Kill a Mockingbird", "Harper Lee", 1960);
        library.findBook("Pride and Prejudice", "Jane Austen", 1813);

        library.removeBook("1984", "George Orwell", 1949);
        library.removeBook("1984", "George Orwell", 1949);

        library.printAllBooks();
    }
}
