package school.faang.task_45405;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("The Catcher in the Rye", "J.D. Salinger", 1951, "A1");
        librarySystem.addBook("To Kill a Mockingbird", "Harper Lee", 1960, "A2");
        librarySystem.addBook("1984", "George Orwell", 1949, "A3");
        librarySystem.addBook("Pride and Prejudice", "Jane Austen", 1813, "A4");
        librarySystem.addBook("The Great Gatsby", "F. Scott Fitzgerald", 1925, "A5");

        librarySystem.removeBook("1984", "George Orwell", 1949);
        librarySystem.removeBook("To Kill a Mockingbird", "Harper Lee", 1960);

        librarySystem.findBook("Pride and Prejudice", "Jane Austen", 1813);
        librarySystem.findBook("1984", "George Orwell", 1949);

        librarySystem.printAllBooks();
    }
}