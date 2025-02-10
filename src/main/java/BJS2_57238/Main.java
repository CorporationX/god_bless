package BJS2_57238;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("The Great Gatsby", "F. Scott Fitzgerald", 1925, "A1");
        librarySystem.addBook("To Kill a Mockingbird", "Harper Lee", 1960, "A2");
        librarySystem.addBook("1984", "George Orwell", 1949, "A3");
        librarySystem.addBook("The Catcher in the Rye", "J.D. Salinger", 1951, "A4");

        librarySystem.printAllBooks();

        System.out.println("-----------------------------------------");
        librarySystem.removeBook("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        librarySystem.printAllBooks();
        System.out.println("-----------------------------------------");
        librarySystem.findBook("To Kill a Mockingbird", "Harper Lee", 1960);
    }
}
