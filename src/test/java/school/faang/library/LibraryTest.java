package school.faang.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
    }

    @Test
    public void addBookTest() {
        library.addBook("Title1", "Author1", 2000, "Location1");
        String location = library.findLocation("Title1", "Author1", 2000);
        assertEquals("Location1", location);
    }

    @Test
    public void deleteBookTest() {
        library.addBook("Title1", "Author1", 2000, "Location1");
        library.deleteBook("Title1", "Author1", 2000);
        String location = library.findLocation("Title1", "Author1", 2000);
        assertNull(location);
    }

    @Test
    public void deleteBookNotFoundTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            library.deleteBook("A Clash of Kings", "George R.R. Martin", 1998);
        });
        assertEquals("Book not found.", exception.getMessage());
    }

    @Test
    public void printAllBooksTest() {
        library.addBook("Title1", "Author1", 2001, "Location1");
        library.addBook("Title2", "Author2", 2002, "Location2");
        library.addBook("Title3", "Author3", 2003, "Location3");

        library.printAllBooks();
    }
}