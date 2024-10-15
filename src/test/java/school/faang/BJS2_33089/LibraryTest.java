package school.faang.BJS2_33089;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.firstStream.BJS2_33089.Book;
import school.faang.firstStream.BJS2_33089.Library;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    public void testAddBookPositive() {
        Book book = new Book("Book A", "Author A", 2024);
        String shelf = "Shelf A";

        library.addBook(book, shelf);

        assertNotNull(library.findBook(book));
    }

    @Test
    void testAddBookNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Library().addBook(null, "Shelf A"));
        assertThrows(IllegalArgumentException.class, () ->
                new Library().addBook(new Book("Book A", "Author A", 2024), null));
    }

    @Test
    void deleteBookPositive() {
        Book book = new Book("Book A", "Author A", 2024);

        library.addBook(book, "Shelf A");
        library.deleteBook(book);

        assertNull(library.findBook(book));
    }

    @Test
    void deleteBookNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Library().deleteBook(null));
    }

    @Test
    void findBook() {
        Book book = new Book("Book B", "Author B", 1997);

        library.addBook(book, "Shelf B");

        assertEquals("Shelf B", library.findBook(book));
    }

    @Test
    void findInvalidBookTitle() {
        Book book = new Book("   ", "Author C", 1876);
        assertThrows(IllegalArgumentException.class, () -> new Library().addBook(book, "Shelf C"));
    }

    @Test
    void findInvalidBookAuthor() {
        Book book = new Book("Book C", "  ", 1876);
        assertThrows(IllegalArgumentException.class, () -> new Library().addBook(book, "Shelf C"));
    }

    @Test
    void findInvalidBookReleaseYear() {
        Book book = new Book("Book C", "Author C", -1);
        assertThrows(IllegalArgumentException.class, () -> new Library().addBook(book, "Shelf C"));
    }
}
