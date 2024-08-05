package BJS2_19344;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<>();
        library.put(new Book("Dragons", "Targarien", 95), "A15");
        library.put(new Book("Armory", "Sir Talos", 534), "B5");
        library.put(new Book("Seas", "Sea Wolf", 200), "B40");
        library.put(new Book("Houses", "Unknown", 12), "C20");
        library.put(new Book("Castles", "Sir Kamelot", 344), "D40");
        library.put(new Book("Plants of Westeros", "Sir Botanic", 222), "D40");

        //Add new book with placement in the library
        addBook(new Book("Kings and Queens", "Martin S. Jones", 101), library, "C30");

        //Remove book
        removeBook(library, new Book("Dragons", "Targarien", 95));

        //Get book from the library
        System.out.println(getBookPlacement(library, new Book("Houses", "Unknown", 12)));

        //Get all books
        getAllBooks(library);
    }

    public static void addBook(Book book, Map<Book, String> library, String placement) {
        if (!library.containsKey(book)) {
            library.put(book, placement);
            System.out.println("Book was added to the library!");
        } else {
            throw new RuntimeException("The book already exists! It's stored in - " + library.get(book));
        }
    }

    public static void removeBook(Map<Book, String> library, Book book) {
        if (library.containsKey(book)) {
            library.remove(book);
            System.out.println("Book " + book.getTitle() + " " + book.getAuthor() + " " + book.getYearOfPublish()
                    + " has been removed!");
        } else {
            throw new RuntimeException("There are no such book in the library!");
        }
    }

    public static String getBookPlacement(Map<Book, String> library, Book book) {
        if (library.containsKey(book)) {
            return "Book stored in : " + library.get(book);
        } else {
            throw new RuntimeException("There are no such book!");
        }
    }

    public static void getAllBooks(Map<Book, String> library) {
        if (!library.isEmpty()) {
            for (Map.Entry<Book, String> entry : library.entrySet()) {
                System.out.println(entry.getKey() + " stored in : " + entry.getValue());
            }
        } else {
            throw new RuntimeException("The library is empty!");
        }
    }

}
