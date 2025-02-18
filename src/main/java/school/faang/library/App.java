package school.faang.library;

public class App {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        // Adding books
        library.addBook("1984", "George Orwell", 1949, "Shelf A1");
        library.addBook("To Kill a Mockingbird", "Harper Lee", 1960, "Shelf B2");
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald", 1925, "Shelf C3");
        library.addBook("Great Expectations", "Charles Dickens", 0, "Shelf C3");
        library.addBook("Pride and Prejudice", "", 1813, "Shelf C3");


        //Display all books
        library.printAllBooks();

        library.findBook("1984", "George Orwell", 1949);

        // Deleting the book
        library.removeBook("To Kill a Mockingbird", "Harper Lee", 1960);

        // Trying to find a deleted book
        library.findBook("To Kill a Mockingbird", "Harper Lee", 1960);
    }
}
