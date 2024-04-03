package faang.school.godbless.javaHashMap.vesterosLibrary;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private Map<Book, String> booksInLibrary;

    {
        booksInLibrary = new HashMap<>();
        booksInLibrary.put(new Book("The Chronicles of Winterfell: Tales from the North", "Maester Aemon", 275),
                "Section A, Shelf 3, Northern History");
        booksInLibrary.put(new Book("Lion's Legacy: A History of House Lannister", "Archmaester Tybald", 310),
                "Section B, Shelf 2, Lannister Family History");
        booksInLibrary.put(new Book("Dragonlore: A Comprehensive Guide to House Targaryen", "Grand Maester Pycelle", 267),
                "Section D, Shelf 4, Targaryen Dynasty Archive");
    }

    public static void main(String[] args) {
        Main library = new Main();
        System.out.println("Library Check.\n");

        System.out.println("Library content at start point:");
        library.printLibraryInfo();


        System.out.println("\nAdding new book:");
        library.addNewBook(new Book("The Reach: A Floral Anthology of House Tyrell", "Lady Olenna Redwyne", 288),
                "Shelf: Section E, Shelf 2, Tyrell Family Records");

        System.out.println("Library content after that:");
        library.printLibraryInfo();


        System.out.println("\nRemoving book of Archmaester Tybald:");
        library.removeBook("Lion's Legacy: A History of House Lannister", "Archmaester Tybald", 310);

        System.out.println("Library content after that:");
        library.printLibraryInfo();


        library.showBooksLocation("Dragonlore: A Comprehensive Guide to House Targaryen", "Grand Maester Pycelle", 267);


        System.out.println("\nLocation of the book \"Lion's Legacy: A History of House Lannister\" (was removed):");
        library.showBooksLocation("Lion's Legacy: A History of House Lannister", "Archmaester Tybald", 310);


    }

    private void addNewBook(Book book, String location) {
        booksInLibrary.put(book, location);
    }

    private void removeBook(String title, String author, int year) {
        Book book = getBookFromLibrary(title, author, year);

        if(book == null) {
            System.out.println("No such book in library!");
            return;
        }

        booksInLibrary.remove(getBookFromLibrary(title, author, year));
    }

    private void showBooksLocation(String title, String author, int year) {
        Book book = getBookFromLibrary(title, author, year);

        if(book == null) {
            System.out.println("No such book in library!");
            return;
        }

        System.out.println("Location of book \"" + book.getTitle() + "\": " + booksInLibrary.get(book));
    }

    private void printLibraryInfo() {
        booksInLibrary.entrySet().forEach(System.out::println);
    }

    private Book getBookFromLibrary(String title, String author, int year) {
        for(Book book : booksInLibrary.keySet()) {
            if(book.equals(new Book(title, author, year))) {
                return book;
            }
        }
        return null;
    }
}
