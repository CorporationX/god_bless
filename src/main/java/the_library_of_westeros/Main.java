package the_library_of_westeros;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static final Map<Book, String> LIBRARY = new HashMap<>();

    public static void main(String[] args) {
        LIBRARY.put(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925), "2");
        LIBRARY.put(new Book("The Catcher in the Rye", "J. D. Salinger", 1951), "1");
        LIBRARY.put(new Book("To Kill a Mockingbird", "Harper Lee", 1960), "3");
        LIBRARY.put(new Book("The Hobbit", "J. R. R. Tolkien", 1937), "2");
        LIBRARY.put(new Book("The Lord of the Rings", "J. R. R. Tolkien", 1954), "1");

        addBook(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997), "2");

        searchAndPrintInfoBook("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997);

        removeBook("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997);

        printAllBooks();
    }

    public static void addBook(Book book, String shelf) {
        LIBRARY.put(book, shelf);
    }

    public static void removeBook(String title, String author, int year) {
        LIBRARY.remove(new Book(title, author, year));
    }

    public static void searchAndPrintInfoBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String result = LIBRARY.get(book);
        System.out.println("The book " + book + " is in the " + result + " shelf");
    }

    public static void printAllBooks() {
        LIBRARY.forEach((k, v) -> System.out.println(k + " is in the " + v + " shelf"));
    }
}
