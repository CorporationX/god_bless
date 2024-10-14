package school.faang.m1s1.bjs_33090_vesterosLibrary;

import java.util.HashMap;
import java.util.Map;

enum Shelf {
    HISTORY,
    COOKING,
    SCIENCE,
    FICTION
}

public class Main {
    private static final Map<Book, Shelf> LIBRARY = new HashMap<>();

    public static void main(String[] args) {

        LIBRARY.putAll(Map.of(
                new Book("History of Vesteros", "Leonardo", 3455), Shelf.HISTORY,
                new Book("Afterlife", "Night King", 1666), Shelf.SCIENCE,
                new Book("Nomad desserts", "Khal Drogo", 4266), Shelf.COOKING,
                new Book("Lord of the Crowns", "R.J. Molkien", 2786), Shelf.FICTION
        ));
        displayLibrary();

        addBook(new Book("My crush", "Jamie Lannister", 2466), Shelf.FICTION);

        deleteBook("Afterlife", "Night King", 1000);
        deleteBook("Afterlife", "Night King", 1666);

        System.out.println();
        searchBook("History of Vesteros", "Leonardo", 3455);
        searchBook("History of Vesteros", "Michelangelo", 3455);

        System.out.println();
        displayLibrary();
    }

    private static void addBook(Book book, Shelf shelf) {
        LIBRARY.put(book, shelf);
    }

    private static void deleteBook(String title, String author, int year) {
        LIBRARY.remove(new Book(title, author, year));
    }

    private static void searchBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        Shelf shelf = LIBRARY.getOrDefault(book, null);

        if (shelf == null) {
            System.out.println("No such book in the library");
        } else {
            System.out.printf("The book '%s', written by %s (%d) can by found on the %s shelf\n",
                    title, author, year, LIBRARY.get(book));
        }
    }

    private static void displayLibrary() {
        for (Map.Entry<Book, Shelf> entry : LIBRARY.entrySet()) {
            Book book = entry.getKey();
            Shelf shelf = entry.getValue();
            System.out.printf("The book '%s', written by %s (%d) can by found on the %s shelf\n",
                    book.getTitle(), book.getAuthor(), book.getYear(), shelf);
        }
    }
}



