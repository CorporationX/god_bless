package school.faang.library;

import java.util.HashMap;
import java.util.Map;

import static school.faang.library.Book.addBook;
import static school.faang.library.Book.deleteBook;
import static school.faang.library.Book.findBook;
import static school.faang.library.Book.listAllBooks;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> books = new HashMap<>();
        books.put(new Book("Book Title1", "Author1", 1900), "1");
        books.put(new Book("Book Title2", "Author2", 1910), "2");

        addBook(books, new Book("Book Title3", "Author3", 1920), "3");
        addBook(books, new Book("Book Title4", "Author4", 1930), "4");
        addBook(books, new Book("Book Title5", "Author5", 1940), "5");

        System.out.println("Book list - initial state :");
        listAllBooks(books);

        System.out.println("\nRemove a book from the list :");
        deleteBook(books, new Book("Book Title4", "Author4", 1930));
        deleteBook(books, "Book Title5", "Author5", 1940);

        System.out.println("\nBook list - after DELETE :");
        listAllBooks(books);

        System.out.println();
        findBook(books, "Book Title2", "Author2", 1910);
    }
}
