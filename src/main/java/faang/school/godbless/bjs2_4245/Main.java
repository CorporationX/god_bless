package faang.school.godbless.bjs2_4245;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Book, String> library = new HashMap<>();

        Book book1 = new Book("Dune", "Frank Gerbert", 1965);
        Book book2 = new Book("Martin Iden", "Jack London", 1909);
        Book book3 = new Book("The Gates of Creation", "Philip Jose Farmer", 1966);

        library.put(book1, "1E");
        library.put(book2, "4C");
        library.put(book3, "9B");

        //Print all books with shelves
        printAllBooks(library);

        //Add book to library
        addBookToLibrary(library, "5E", new Book("The Hobbit", "John Tolkien", 1937));
        System.out.println("Library after add one");
        printAllBooks(library);

        //Delete Book
        deleteBook(library, "Martin Iden", "Jack London", 1909);
        System.out.println("Library after remove one");
        printAllBooks(library);

        //Print books shelf
        System.out.println("Print book shelf for \"The Gates of Creation\"");
        printBookShelf(library, "The Gates of Creation", "Philip Jose Farmer", 1966);
    }

    public static void addBookToLibrary(Map<Book, String> library, String shelfNumber, Book book) {
        library.put(book, shelfNumber);
    }

    public static void deleteBook(Map<Book, String> library, String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    public static void printBookShelf(Map<Book, String> library, String title, String author, int year) {
        System.out.println(library.get(new Book(title, author, year)));
    }

    public static void printAllBooks(Map<Book, String> library) {
        for (Map.Entry<Book, String> bookEntry : library.entrySet()) {
            System.out.println(bookEntry.getKey() + ", Shelf: " + bookEntry.getValue());
        }
    }
}
