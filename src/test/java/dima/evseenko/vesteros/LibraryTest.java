package dima.evseenko.vesteros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LibraryTest {

    @Test
    void addBook() {
        Book book = new Book("Book", "Author", 2000);

        Library lib = new Library();
        lib.addBook(book, "1 полка");

        assertNotNull(lib.findBook(book));
    }

    @Test
    void addNullBookOrNullShelf() {
        Library lib = new Library();

        assertThrows(IllegalArgumentException.class, () -> lib.addBook(null, "1 полка"));
        assertThrows(IllegalArgumentException.class, () -> lib.addBook(new Book("Book", "Author", 2000), null));
    }

    @Test
    void deleteBook() {
        Book book = new Book("Book", "Author", 2000);

        Library lib = new Library();
        lib.addBook(book, "1 полка");
        lib.deleteBook(book);

        assertNull(lib.findBook(book));
    }

    @Test
    void deleteNullBook() {
        Library lib = new Library();

        assertThrows(IllegalArgumentException.class, () -> lib.deleteBook(null));
    }

    @Test
    void findBook() {
        Book book = new Book("Book", "Author", 2000);

        Library lib = new Library();
        lib.addBook(book, "1 полка");

        assertEquals("1 полка", lib.findBook("Book", "Author", 2000));
    }

    @Test
    void findNullBook() {
        Library lib = new Library();

        assertThrows(IllegalArgumentException.class, () -> lib.findBook(null));
    }
}