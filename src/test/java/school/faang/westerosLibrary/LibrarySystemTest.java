package school.faang.westerosLibrary;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

        librarySystem.removeBook("Dragons and Balls", "random", 2002);

        assertFalse(librarySystem.getBookLocations().containsKey(book));
    }

    @Test
    void shouldFindBook() {
        librarySystem.addBook("Dragons and Balls", "J. J. Martin", 2005, "5");

        Book book = librarySystem.findBook("Dragons and Balls", "J. J. Martin", 2005);

        assertEquals(book.getAuthor(), "J. J. Martin");
        assertEquals(book.getTitle(), "Dragons and Balls");
        assertEquals(book.getYear(), 2005);
    }
}