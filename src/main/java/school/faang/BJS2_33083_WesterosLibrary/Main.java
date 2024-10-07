package school.faang.BJS2_33083_WesterosLibrary;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> bookToShelf = new HashMap<>();

    public static void main(String[] args) {
        Book theGreatGatsby = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Book toKillAMockingbird = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        Book nineteenEightyFour = new Book("1984", "George Orwell", 1949);
        Book braveNewWorld = new Book("Brave New World", "Aldous Huxley", 1932);
        Book theCatcherInTheRye = new Book("The Catcher in the Rye", "J.D. Salinger", 1951);
        Book theHobbit = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        Book theLordOfTheRings = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);

        addBookLocation(theGreatGatsby, "A1");
        addBookLocation(toKillAMockingbird, "B3");
        addBookLocation(nineteenEightyFour, "C2");
        addBookLocation(braveNewWorld, "D5");
        addBookLocation(theCatcherInTheRye, "A2");
        addBookLocation(theHobbit, "B1");
        addBookLocation(theLordOfTheRings, "C3");

        printLibraryBooksLocations();
        System.out.println("---------------");
        printBookLocation("The Catcher in the Rye", "J.D. Salinger", 1951);
        printBookLocation("To Kill a Mockingbird", "Harper Lee", 1960);
        System.out.println("---------------");
        deleteBookInfo("Brave New World", "Aldous Huxley", 1932);
        deleteBookInfo("To Kill a Mockingbird", "Harper Lee", 1960);
        printLibraryBooksLocations();
        System.out.println("---------------");
        printBookLocation("To Kill a Mockingbird", "Harper Lee", 1960);
    }

    private static void addBookLocation(Book book, String shelf) {
        bookToShelf.put(book, shelf);
    }

    private static void deleteBookInfo(String title, String author, int year) {
        bookToShelf.remove(new Book(title, author, year));
    }

    private static void printBookLocation(String title, String author, int year) {
        Book requiredBook = new Book(title, author, year);
        String location = bookToShelf.get(requiredBook);

        System.out.println(location != null ? bookShelfInfo(requiredBook, location) : "There is no such book.");
    }

    private static void printLibraryBooksLocations() {
        for (var entry : bookToShelf.entrySet()) {
            System.out.println(bookShelfInfo(entry.getKey(), entry.getValue()));
        }
    }

    private static String bookShelfInfo(Book book, String shelf) {
        return book + "\n\tshelf: " + shelf;
    }
}
