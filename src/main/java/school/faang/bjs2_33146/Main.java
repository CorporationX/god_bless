package school.faang.bjs2_33146;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> bookShelfMap = new HashMap<>() {{
            put(new Book("1984", "George Orwell", 1949), "Shelf 1");
            put(new Book("Brave New World", "Aldous Huxley", 1932), "Shelf 2");
            put(new Book("Fahrenheit 451", "Ray Bradbury", 1953), "Shelf 3");
            put(new Book("The Catcher in the Rye", "J.D. Salinger", 1951), "Shelf 4");
            put(new Book("To Kill a Mockingbird", "Harper Lee", 1960), "Shelf 5");
        }};
        testAddBookAndShelf(bookShelfMap);
        testRemoveBook(bookShelfMap);
        testPrintBookLocation(bookShelfMap);
    }

    public static void testAddBookAndShelf(Map<Book, String> bookShelfMap) {
        Book bookForAdd = new Book("Crime and Punishment", "Fyodor Dostoevsky", 1866);
        String shelfForAdd = "Shelf 4";

        System.out.println("bookShelfMap before: " + bookShelfMap);
        BookShelfUtils.addBookAndShelf(bookForAdd, shelfForAdd, bookShelfMap);

        System.out.println("added: " + bookForAdd + " - " + shelfForAdd);
        System.out.println("bookShelfMap after: " + bookShelfMap + "\n");
    }

    public static void testRemoveBook(Map<Book, String> bookShelfMap) {
        String title = "Fahrenheit 451";
        String author = "Ray Bradbury";
        int year = 1953;

        System.out.println("bookShelfMap before: " + bookShelfMap);
        System.out.println("removedBook: " + "title - " + title + ", author - " + author + ", year - " + year);
        BookShelfUtils.removeBook(title, author, year, bookShelfMap);
        System.out.println("bookShelfMap after: " + bookShelfMap + "\n");
    }

    public static void testPrintBookLocation(Map<Book, String> bookShelfMap){
        String title = "1984";
        String author = "George Orwell";
        int year = 1949;
        BookShelfUtils.printBookLocation(title,author,year,bookShelfMap);
        System.out.println();
    }
}
