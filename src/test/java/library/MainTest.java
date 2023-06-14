package library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @BeforeEach
    public void setUp() {
        Main.library = new HashMap<>();
    }


    @Test
    public void testAddBook() {
        Book book = new Book("Title 1", "Author 1", 2001);
        String shelf = "Shelf 1";

        Main.addBook(book, shelf);

        assertTrue(Main.library.containsKey(book));
        assertEquals(shelf, Main.library.get(book));
    }

    @Test
    public void testRemoveBookByDetails_BookExists() {
        Book book1 = new Book("Title 1", "Author 1", 2001);
        Book book2 = new Book("Title 2", "Author 2", 2002);
        String shelf1 = "Shelf 1";
        String shelf2 = "Shelf 2";

        Main.addBook(book1, shelf1);
        Main.addBook(book2, shelf2);

        Main.removeBookByDetails("Title 1", "Author 1", 2001);

        assertFalse(Main.library.containsKey(book1));
        assertTrue(Main.library.containsKey(book2));
    }

    @Test
    public void testRemoveBookByDetails_BookDoesNotExist() {
        Book book = new Book("Title 1", "Author 1", 2001);
        String shelf = "Shelf 1";

        Main.addBook(book, shelf);

        Main.removeBookByDetails("Title 2", "Author 2", 2003);

        assertTrue(Main.library.containsKey(book));
    }

    @Test
    public void testFindBookLocation_BookFound() {
        Book book = new Book("Title 1", "Author 1", 2001);
        String shelf = "Shelf 1";

        Main.addBook(book, shelf);

        String location = Main.findBookLocation("Title 1", "Author 1", 2001);
        assertEquals(shelf, location);
    }


    @Test
    public void testFindBookLocation_BookNotFound() {
        Book book = new Book("Title 1", "Author 1", 2001);
        String shelf = "Shelf 1";

        Main.addBook(book, shelf);
        String location = Main.findBookLocation("Title 2", "Author 2", 2002);

        assertNull(location);
    }
}
