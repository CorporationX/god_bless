package the_library_of_westeros;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Main {
    @Getter
    private static final Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        library.put(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925), "2");
        library.put(new Book("The Catcher in the Rye", "J. D. Salinger", 1951), "1");
        library.put(new Book("To Kill a Mockingbird", "Harper Lee", 1960), "3");
        library.put(new Book("The Hobbit", "J. R. R. Tolkien", 1937), "2");
        library.put(new Book("The Lord of the Rings", "J. R. R. Tolkien", 1954), "1");

        addBook(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997), "2");

        searchAndPrintInfoBook(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997));

        removeBook("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997);

        printAllBooks();
    }

    public static void addBook(Book book, String shelf) {
        library.put(book, shelf);
    }

    public static void removeBook(String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    public static void searchAndPrintInfoBook(Book book) {
        String result = library.get(book);
        System.out.println("The book " + book + " is in the " + result + " shelf");
    }

    public static void printAllBooks() {
        library.forEach((k, v) -> System.out.println(k + " is in the " + v + " shelf"));
    }
}
