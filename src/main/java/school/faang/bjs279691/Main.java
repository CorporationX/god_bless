package school.faang.bjs279691;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        library.addBook("1984", "George Orwell", 1949, "Shelf A");
        library.addBook("Brave New World", "Aldous Huxley", 1932, "Shelf B");
        library.addBook("Fahrenheit 451", "Ray Bradbury", 1953, "Shelf C");
        library.addBook("The Catcher in the Rye", "J.D. Salinger", 1951, "Shelf D");
        library.addBook("Crime and Punishment", "Fyodor Dostoevsky", 1866, "Shelf E");
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald", 1925, "Shelf F");

        library.removeBook("The Catcher in the Rye", "J.D. Salinger", 1951);

        library.findBook("The Catcher in the Rye", "J.D. Salinger", 1951);
        library.findBook("The Great Gatsby", "F. Scott Fitzgerald", 1925);

        library.printAllBooks();


    }
}
