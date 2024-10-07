package school.faang.T33122;

import java.util.HashMap;
import java.util.Map;

public class Main {

    Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.addBook(new Book("Title book 1", "Author 1", 2001), "Regal 1");
        main.addBook(new Book("Title book 4", "Author 4", 2002), "Regal 2");
        main.addBook(new Book("Title book 3", "Author 3", 2002), "Regal 1");
        main.printAllBooks();

        Book book = new Book("Title book 3", "Author 3", 2002);
        System.out.printf("Looking for a book: %s ====> The book is: %s", book, main.searchBook(book));

        main.deleteBook(book);
        main.printAllBooks();
    }

    public void addBook(Book book, String regal) {
        library.put(book, regal);
    }

    public void deleteBook(Book book) {
        library.remove(book);
    }

    public String searchBook(Book book) {
        return library.get(book);
    }

    public void printAllBooks() {
        System.out.println("\n=== Library ===");
        library.forEach((book, s) -> System.out.printf("Regal: %s || Book: %s\n", s, book.toString()));
    }
}