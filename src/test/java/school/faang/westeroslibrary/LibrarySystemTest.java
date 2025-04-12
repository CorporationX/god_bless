package school.faang.westeroslibrary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibrarySystemTest {
    private LibrarySystem librarySystem;

    @BeforeEach
    void setUp() {
        librarySystem = new LibrarySystem();
    }

    @Test
    void shouldAddBook() {
        Book book = librarySystem.addBook("Dragons and Balls", "J. J. Martin", 2005, "5");

        assertTrue(librarySystem.getBookLocations().containsKey(book));
        assertTrue(librarySystem.getBookLocations().get(book).equals("5"));
    }

    @Test
    void shouldRemoveBook() {
        Book book = librarySystem.addBook("Dragons and Balls", "J. J. Martin", 2005, "5");

        boolean isRemoved = librarySystem.removeBook("Dragons and Balls", "J. J. Martin", 2005);

        assertFalse(librarySystem.getBookLocations().containsKey(book));
        assertTrue(isRemoved);
    }

    @Test
    void shouldFindBook() {
        librarySystem.addBook("Dragons and Balls", "J. J. Martin", 2005, "5");

        String bookLocation = librarySystem.findBook("Dragons and Balls", "J. J. Martin", 2005);

        assertEquals(bookLocation, "5");
    }
}