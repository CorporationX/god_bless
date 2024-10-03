package school.faang.bjs_33090_vesterosLibrary;

import java.util.HashMap;
import java.util.Map;

enum Shelf {
    HISTORY,
    COOKING,
    SCIENCE,
    FICTION
}

public class Main {
    public static final Map<Book, Shelf> LIBRARY = new HashMap<>();

    public static void main(String[] args) {

        // Adding books to the ßlibrary
        LIBRARY.putAll(Map.of(
                new Book("History of Vesteros", "Leonardo", 3455), Shelf.HISTORY,
                new Book("Afterlife", "Night King", 1666), Shelf.SCIENCE,
                new Book("Nomad desserts", "Khal Drogo", 4266), Shelf.COOKING,
                new Book("Lord of the Crowns", "R.J. Molkien", 2786), Shelf.FICTION
        ));
        System.out.println(LIBRARY);

        //Adding new book with a addBook method
        addBook(new Book("My crush", "Jamie Lannister", 2466), Shelf.FICTION);
        System.out.println(LIBRARY);

        //Removing book with deleteBook method
        deleteBook("Afterlife", "Night King", 1000);
        deleteBook("Afterlife", "Night King", 1666);
        System.out.println(LIBRARY);

        //Searching for book with searchBook method
        searchBook("History of Vesteros", "Leonardo", 3455);

        //Showing all books with displayLibrary method
        displayLibrary();
    }

    public static void addBook(Book book, Shelf shelf) {
        LIBRARY.put(book, shelf);
    }

    public static void deleteBook(String title, String author, int year) {
        LIBRARY.remove(new Book(title, author, year));
    }

    public static void searchBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (LIBRARY.containsKey(book)) {
            System.out.printf("The book '%s', written by %s (%d) can by found on the %s shelf\n",
                    title, author, year, LIBRARY.get(book));
        } else {
            System.out.println("No such book in the library");
        }
    }

    public static void displayLibrary() {
        for (Map.Entry<Book, Shelf> entry : LIBRARY.entrySet()) {
            Book book = entry.getKey();
            Shelf shelf = entry.getValue();
            System.out.printf("The book '%s', written by %s (%d) can by found on the %s shelf\n",
                    book.getTitle(), book.getAuthor(), book.getYear(), shelf);
        }
    }
}



