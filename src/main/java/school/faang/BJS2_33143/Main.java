package school.faang.BJS2_33143;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Map<Book, String> library = new HashMap<>();

    public static void addBook(Book book, String location) {
        library.put(book, location);
        System.out.println("The book has been added: " + book.getTitle() + " to the place: " + location);
    }

    public static void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        if (library.remove(bookToRemove) != null) {
            System.out.println("The book has been deleted: " + title);
        } else {
            System.out.println("The book was not found: " + title);
        }
    }

    public static String findBook(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);
        return library.getOrDefault(bookToFind, "The book was not found in the library.");
    }

    public static void listAllBooks() {
        Set<Map.Entry<Book, String>> entries = library.entrySet();
        for (Map.Entry<Book, String> entry : entries) {
            Book book = entry.getKey();
            String location = entry.getValue();
            System.out.println("Book: " + book.getTitle() + ", Author: " + book.getAuthor() +
                    ", year: " + book.getYear() + " - Location: " + location);
        }
    }

    public static void main(String[] args) {

        addBook(new Book("Title", "Stepan", 1999), "Shelf 1");
        addBook(new Book("Animal Farm", "Lee", 1975), "Shelf 2");
        addBook(new Book("The Great Gatsby", "King", 1988), "Shelf 3");

        System.out.println("List of books:");
        listAllBooks();

        String location = findBook("Title", "Stepan", 1999);
        System.out.println("The location of the book 'Title': " + location);

        removeBook("The Great Gatsby", "King", 1988);

        System.out.println("List of books after deletion:");
        listAllBooks();
    }
}
