import hasmap.library.Book;
import hasmap.library.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HashMapTest {
    @Test
    @DisplayName("Adding book in map")
    void hashMapTest_addBook() {
        Book testBook = new Book("Test", "Test", 100);

        Main.addBook(testBook, "section test");

        assertTrue(Main.LIBRARY_MAP.containsKey(testBook));
        Main.removeBook(testBook.getTitle(), testBook.getAuthor(), testBook.getYear());
    }

    @Test
    @DisplayName("Adding null book in map")
    void hashMapTest_addNullBook() {
        Book testBook = null;

        assertThrows(NullPointerException.class, () -> Main.addBook(testBook, "section test"));
    }

    @Test
    @DisplayName("Adding book in null section in map")
    void hashMapTest_addBookInNullSection() {
        Book testBook = new Book("Test", "Test", 100);

        assertThrows(NullPointerException.class, () -> Main.addBook(testBook, null));
    }

    @Test
    @DisplayName("Remove book from map")
    void hashMapTest_removeBook() {
        Book testBook = new Book("Test", "Test", 100);

        Main.addBook(testBook, "section test");
        Main.removeBook(testBook.getTitle(), testBook.getAuthor(), testBook.getYear());

        assertFalse(Main.LIBRARY_MAP.containsKey(testBook));
    }

    @Test
    @DisplayName("Remove book with null arguments from map")
    void hashMapTest_removeNullBook() {
        assertThrows(NullPointerException.class, () -> Main.removeBook(null, null, 0));
    }

    @Test
    @DisplayName("Search book in map")
    void hashMapTest_searchBook() {
        Book testBook = new Book("Test", "Test", 100);

        Main.addBook(testBook, "section test");
        Book result = Main.searchBook(testBook.getTitle(), testBook.getAuthor(), testBook.getYear());

        assertEquals(testBook, result);
    }

    @Test
    @DisplayName("Search book with null arguments")
    void hashMapTest_searchNullBook() {
        assertThrows(NullPointerException.class, () -> Main.searchBook(null, null, 9));
    }
}
