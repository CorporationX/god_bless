package school.faang.bjs2_68666;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("To Kill a Mockingbird", "Harper Lee", 1960, "1st shelf");
        librarySystem.addBook("1984", "George Orwell", 1949, "2nd shelf");
        librarySystem.addBook("Pride and Prejudice", "Jane Austen", 1813, "3rd shelf");
        librarySystem.addBook("The Great Gatsby", "F. Scott Fitzgerald", 1925, "4th shelf");
        librarySystem.addBook("The Catcher in the Rye", "J.D. Salinger", 1951, "5th shelf");

        librarySystem.removeBook("To Kill a Mockingbird", "Harper Lee", 1960);

        System.out.println(librarySystem.findBook("The Great Gatsby", "F. Scott Fitzgerald", 1925));

        System.out.println(librarySystem.printAllBooks());
    }
}
