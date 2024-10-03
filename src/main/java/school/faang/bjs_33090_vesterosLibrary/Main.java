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
    private static final Map<Book, Shelf> library = new HashMap<>();

    public static void main(String[] args) {

        library.putAll(Map.of(
                new Book("History of Vesteros", "Leonardo", 3455), Shelf.HISTORY,
                new Book("Afterlife", "Night King", 1666), Shelf.SCIENCE,
                new Book("Nomad desserts", "Khal Drogo", 4266), Shelf.COOKING,
                new Book("Lord of the Crowns", "R.J. Molkien", 2786), Shelf.FICTION
        ));
        displayLibrary();

        addBook(new Book("My crush", "Jamie Lannister", 2466), Shelf.FICTION);

        deleteBook("Afterlife", "Night King", 1000);
        deleteBook("Afterlife", "Night King", 1666);

        searchBook("History of Vesteros", "Leonardo", 3455);

        displayLibrary();
    }

    private static void addBook(Book book, Shelf shelf) {
        library.put(book, shelf);
    }

    private static void deleteBook(String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    private static void searchBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            System.out.printf("The book '%s', written by %s (%d) can by found on the %s shelf\n",
                    title, author, year, library.get(book));
        } else {
            System.out.println("No such book in the library");
        }
    }

    private static void displayLibrary() {
        for (Map.Entry<Book, Shelf> entry : library.entrySet()) {
            Book book = entry.getKey();
            Shelf shelf = entry.getValue();
            System.out.printf("The book '%s', written by %s (%d) can by found on the %s shelf\n",
                    book.getTitle(), book.getAuthor(), book.getYear(), shelf);
        }
    }
}



