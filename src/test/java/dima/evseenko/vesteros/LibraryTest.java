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
        assertThrows(IllegalArgumentException.class, () -> new Library().addBook(null, "1 полка"));
        assertThrows(IllegalArgumentException.class, () -> new Library().addBook(new Book("Book", "Author", 2000), null));
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
        assertThrows(IllegalArgumentException.class, () -> new Library().deleteBook(null));
    }

    @Test
    void findBook() {
        Book book = new Book("Book", "Author", 2000);

        Library lib = new Library();
        lib.addBook(book, "1 полка");

        assertEquals("1 полка", lib.findBook("Book", "Author", 2000));
    }

    @Test
    void findInvalidBookTitle() {
        Book book = new Book(null, "Author", 2000);

        assertThrows(IllegalArgumentException.class, () -> new Library().addBook(book, "1 полка"));
    }

    @Test
    void findInvalidBookAuthor() {
        Book book = new Book("Book", null, 2000);

        assertThrows(IllegalArgumentException.class, () -> new Library().addBook(book, "1 полка"));
    }

    @Test
    void findInvalidBookReleaseYear() {
        Book book = new Book("Book", "Author", -1000);

        assertThrows(IllegalArgumentException.class, () -> new Library().addBook(book, "1 полка"));
    }

    @Test
    void findNullBook() {
        assertThrows(IllegalArgumentException.class, () -> new Library().findBook(null));
    }

    @Test
    void findNotExistsBook(){
        assertNull(new Library().findBook("Book", "Author", 2000));
    }
}