import hasmap.library.Book;
import hasmap.library.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HashMapTest {
    private static Map<Book, String> libraryMap;

    @BeforeEach
    void setUp() {
        libraryMap = new HashMap<>();
    }

    @Test
    @DisplayName("Adding book in map")
    void hashMapTest_addBook() {
        Book testBook = new Book("Test", "Test", 100);

        Main.addBook(libraryMap, testBook, "section test");

        assertTrue(libraryMap.containsKey(testBook));
    }

    @Test
    @DisplayName("Adding null book in map")
    void hashMapTest_addNullBook() {
        Book testBook = null;

        assertThrows(NullPointerException.class, () -> Main.addBook(libraryMap, testBook, "section test"));
    }

    @Test
    @DisplayName("Adding book in null section in map")
    void hashMapTest_addBookInNullSection() {
        Book testBook = new Book("Test", "Test", 100);

        assertThrows(NullPointerException.class, () -> Main.addBook(libraryMap, testBook, null));
    }

    @Test
    @DisplayName("Remove book from map")
    void hashMapTest_removeBook() {
        Book testBook = new Book("Test", "Test", 100);

        Main.addBook(libraryMap, testBook, "section test");
        assertTrue(libraryMap.containsKey(testBook));

        Main.removeBook(libraryMap, testBook.getTitle(), testBook.getAuthor(), testBook.getYear());
        assertFalse(libraryMap.containsKey(testBook));
    }

    @Test
    @DisplayName("Remove book with null arguments from map")
    void hashMapTest_removeNullBook() {
        assertThrows(NullPointerException.class, () -> Main.removeBook(libraryMap, null, null, 0));
    }

    @Test
    @DisplayName("Search book in map")
    void hashMapTest_searchBook() {
        Book testBook = new Book("Test", "Test", 100);

        Main.addBook(libraryMap, testBook, "section test");
        Book result = Main.searchBook(libraryMap, testBook.getTitle(), testBook.getAuthor(), testBook.getYear());

        assertEquals(testBook, result);
    }

    @Test
    @DisplayName("Search book with null arguments")
    void hashMapTest_searchNullBook() {
        assertThrows(NullPointerException.class, () -> Main.searchBook(libraryMap, null, null, 9));
    }
}
