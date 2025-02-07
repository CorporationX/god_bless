package school.faang.sprint1.collections.vesteroslibrary;

import school.faang.sprint1.collections.vesteroslibrary.exceptions.BookNotFoundException;
import school.faang.sprint1.collections.vesteroslibrary.exceptions.DuplicateBookException;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        try {
            library.addBook("1984", "George Orwell", 1949, "shelf 1");
            library.addBook("The Hobbit", "J.R.R. Tolkien", 1937, "shelf 2");
            library.addBook("War and Peace", "Leo Tolstoy", 1869, "shelf 3");
            library.addBook("Pride and Prejudice", "Jane Austen", 1813, "shelf 4");

            library.printAllBooks();
            library.findBook("War and Peace", "Leo Tolstoy", 1869);
            library.removeBook("War and Peace", "Leo Tolstoy", 1869);
            System.out.println("\n.........");
            library.printAllBooks();
            library.removeBook("Brave New World", "Aldous Huxley", 1932);
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (DuplicateBookException e) {
            System.out.println(e.getMessage());
        }
    }
}
