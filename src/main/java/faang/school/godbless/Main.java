package faang.school.godbless;


import java.util.HashMap;
import java.util.Map;

public class Main {
    private final static HashMap<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        Librarian librarian = new Librarian(library);

        // Add
        librarian.addBook(new Book("1984", "George Orwell", 1949), "F1");
        librarian.addBook(new Book("1984", "George Orwell", 1950), "F1");
        librarian.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 1960), "F2");
        librarian.addBook(new Book("Moby Dick", "Herman Melville", 1851), "F4");
        librarian.addBook(new Book("War and Peace", "Leo Tolstoy", 1869), "F5");
        librarian.addBook(new Book("Pride and Prejudice", "Jane Austen", 1813), "F6");
        librarian.addBook(new Book("The Hobbit", "J.R.R. Tolkien", 1937), "F8");
        librarian.addBook(new Book("Crime and Punishment", "Fyodor Dostoevsky", 1866), "F13");

        // Print
        System.out.println("\n");
        librarian.printAllBooks();

        // Search
        String bookTitle = "1984";
        Map<Book, String> searchResult = librarian.findBooksLocationByTitle(bookTitle);
        printSearchResult(bookTitle, searchResult);

        // Remove
        bookTitle = "To Kill a Mockingbird";

        searchResult = librarian.findBooksLocationByTitle(bookTitle);
        printSearchResult(bookTitle, searchResult);

        librarian.removeBooksByTitle(bookTitle);
        librarian.removeBooksByAuthor("J.R.R. Tolkien");
        librarian.removeBooksByYear(1866);

        // Search
        searchResult = librarian.findBooksLocationByTitle(bookTitle);
        printSearchResult(bookTitle, searchResult);

        searchResult = librarian.findBooksLocationByAuthor("George Orwell");
        printSearchResult("George Orwell", searchResult);

        searchResult = librarian.findBooksLocationByYear(1866);
        printSearchResult("1866", searchResult);

        // Print
        System.out.println("\n");
        librarian.printAllBooks();
    }

    public static void printSearchResult(String searchQuery, Map<Book, String> searchResult) {
        if (searchResult.isEmpty()) {
            System.out.println("Result with query: " + searchQuery + " not found in the library");
        } else {
            searchResult.forEach((book, location) ->
                    System.out.println("Book: " + book.getTitle() + " | Location: " + location));
        }
    }
}
