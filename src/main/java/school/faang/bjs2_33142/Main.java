package school.faang.bjs2_33142;

import java.util.Map;
import java.util.HashMap;

public class Main {
    private static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        Book book1 = new Book("Kak to tak", "Mark Tven", 1526);
        Book book2 = new Book("Nepolucilos", "Tas Bulba", 1245);
        Book book3 = new Book("Tuda i obratno", "Tolkin", 1245);

        addBook(book1, "Shelf 1");


        library.put(book1, "Shelf 1");

        String location = library.get(book1);
        if (location != null) {
            System.out.println(book1.getTitle() + " where it is " + location);
        }

        printAllBooks();

        serachBook(book1);

        removeBooks(book2);
    }

    private static void removeBooks(Book book) {
        if (library.containsKey(book)) {
            library.remove(book);
            System.out.println("Book removed; " + book.getTitle());
        } else {
            System.out.println("Book not found ;" + book.getTitle());
        }
    }

    private static void serachBook(Book book) {
        String location = library.get(book);
        if (location != null) {
            System.out.println(book.getTitle() + " is located " + location);
        } else {
            System.out.println("Book not found; " + book.getTitle());
        }
    }

    private static void printAllBooks() {
        if (library.isEmpty()) {
            System.out.println("No books in library; ");
        } else {
            System.out.println("Library books and location");
            for (Map.Entry<Book, String> listOfBooks : library.entrySet()) {
                System.out.println(listOfBooks.getKey().getTitle() + " by " + listOfBooks.getKey().getAuthor() + " ( " + listOfBooks.getKey().getYear() + " ) is located at " + listOfBooks.getValue());
            }
        }
    }

    private static void addBook(Book book, String location) {
        library.put(book, location);
        System.out.println("Book added; " + book.getTitle() + "is located at " + location);
    }

}
