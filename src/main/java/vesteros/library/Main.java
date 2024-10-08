package vesteros.library;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<Book, String> library;

    public static void main(String[] args) {
        library = new HashMap<>();
        Book bookOne = new Book("Stark's house", "Author S", 1007);
        Book bookTwo = new Book("Baratheon's house", "Author B", 1008);
        Book bookThree = new Book("Targarien's house", "Author T", 990);
        Book bookFour = new Book("Greyjoy's house", "Author G", 1011);

        addBookToLibrary(library, bookOne, "Shelf S");
        addBookToLibrary(library, bookTwo, "Shelf B");
        addBookToLibrary(library, bookThree, "Shelf T");
        addBookToLibrary(library, bookFour, "Shelf G");

        removeBookFromLibrary(library,"Baratheon's house", "Author B", 1008);

        findBookInLibrary(library,"Greyjoy's house", "Author G", 1011);

        printAllBooksFromLibrary(library);
    }

    public static void addBookToLibrary(Map<Book, String> library, Book book, String shelf) {
        if (book == null) {
            throw new IllegalArgumentException("Incorrect book value: " + book);
        } else if (shelf == null) {
            throw new IllegalArgumentException("Incorrect shelf value: " + shelf);
        }
        library.put(book, shelf);
    }

    public static void removeBookFromLibrary(Map<Book, String> library, String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    public static String findBookInLibrary(Map<Book, String> library, String title, String author, int year) {
        return library.get(new Book(title, author, year));
    }

    public static void printAllBooksFromLibrary(Map<Book, String> library) {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println(entry.getKey().toString() + " Location: " + entry.getValue());
        }
    }
}
