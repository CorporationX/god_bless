package vesteros.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class VesterosLibraryTest {
    private static Map<Book, String> library;
    private Book testBook;
    private String shelf = "Test shelf";
    private String testBookTitle = "Stark's house";
    private String testBookAuthor = "Author S";
    private int testBookYear = 1007;

    @BeforeEach
    void setup() {
        library = new HashMap<>();
        testBook = new Book(testBookTitle, testBookAuthor, testBookYear);

        Main.addBookToLibrary(library, testBook, shelf);
    }

    @Test
    void testAddBookToLibrary() {
        Assertions.assertTrue(library.containsKey(testBook));
        Assertions.assertTrue(library.containsValue(shelf));
        Assertions.assertEquals(1, library.size());
    }

    @Test
    void testAddBookWithNullArgToLibrary() {
        Assertions.assertThrows(NullPointerException.class, () -> Main.addBookToLibrary(library, null, shelf));
        Assertions.assertThrows(NullPointerException.class, () -> Main.addBookToLibrary(library, testBook, null));
    }

    @Test
    void testRemoveBookFromLibrary() {
        Main.removeBookFromLibrary(library, testBookTitle, testBookAuthor, testBookYear);

        Assertions.assertFalse(library.containsKey(testBook));
        Assertions.assertFalse(library.containsValue(shelf));
        Assertions.assertEquals(0, library.size());
    }

    @Test
    void testFindBookInLibrary() {
        Assertions.assertEquals(shelf, Main.findBookInLibrary(library, testBookTitle, testBookAuthor, testBookYear));
    }
}
