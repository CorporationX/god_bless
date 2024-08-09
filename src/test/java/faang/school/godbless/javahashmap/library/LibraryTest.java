package faang.school.godbless.javahashmap.library;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private static final Book BOOK_1 = new Book("Book 1", "Author 1", 2000);
    private static final Book BOOK_2 = new Book("Book 2", "Author 2", 2001);
    private static final Book BOOK_3 = new Book("Book 3", "Author 3", 2002);
    private static final Book BOOK_NOT_EXIST = new Book("Not exist", "Not exist", 0);
    private static final String SHELF_1 = "Shelf 1";
    private static final String SHELF_2 = "Shelf 2";
    private static final String SHELF_3 = "Shelf 3";
    private static final String BOOK_2_INFO = "Book: Book(title=Book 2, author=Author 2, year=2001), Location: Shelf 2\r\n";
    private static final String ALL_BOOK_INFO = """
            Book: Book(title=Book 3, author=Author 3, year=2002), Location: Shelf 3\r
            Book: Book(title=Book 2, author=Author 2, year=2001), Location: Shelf 2\r
            Book: Book(title=Book 1, author=Author 1, year=2000), Location: Shelf 1\r
            """;
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @Test
    void testAddBook() {
        Library library = new Library();
        library.addBook(BOOK_1, SHELF_1);
        library.addBook(BOOK_2, SHELF_2);
        library.addBook(BOOK_3, SHELF_3);

        HashMap<Book, String> store = library.getStore();
        assertEquals(3, store.size());
        assertEquals(SHELF_1, store.get(BOOK_1));
        assertEquals(SHELF_2, store.get(BOOK_2));
        assertEquals(SHELF_3, store.get(BOOK_3));
    }

    @Test
    void testRemoveBook() {
        Library library = new Library();
        library.addBook(BOOK_1, SHELF_1);
        library.addBook(BOOK_2, SHELF_2);
        library.addBook(BOOK_3, SHELF_3);

        library.removeBook(BOOK_2.getTitle(), BOOK_2.getAuthor(), BOOK_2.getYear());

        HashMap<Book, String> store = library.getStore();
        assertEquals(2, store.size());
        assertFalse(store.containsKey(BOOK_2));
        assertEquals(SHELF_1, store.get(BOOK_1));
        assertEquals(SHELF_3, store.get(BOOK_3));
    }

    @Test
    void testRemoveBookNotExist() {
        Library library = new Library();
        library.addBook(BOOK_1, SHELF_1);
        library.addBook(BOOK_2, SHELF_2);
        library.addBook(BOOK_3, SHELF_3);

        library.removeBook(BOOK_NOT_EXIST.getTitle(), BOOK_NOT_EXIST.getAuthor(), BOOK_NOT_EXIST.getYear());

        HashMap<Book, String> store = library.getStore();
        assertEquals(3, store.size());
        assertEquals(SHELF_1, store.get(BOOK_1));
        assertEquals(SHELF_2, store.get(BOOK_2));
        assertEquals(SHELF_3, store.get(BOOK_3));
    }

    @Test
    void testFindAndPrintBook() {
        System.setOut(new PrintStream(outContent));
        outContent.reset();

        Library library = new Library();
        library.addBook(BOOK_1, SHELF_1);
        library.addBook(BOOK_2, SHELF_2);
        library.addBook(BOOK_3, SHELF_3);

        library.findAndPrintBook(BOOK_2.getTitle(), BOOK_2.getAuthor(), BOOK_2.getYear());

        assertEquals(BOOK_2_INFO, outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    void testPrintAllBooks() {
        System.setOut(new PrintStream(outContent));
        outContent.reset();

        Library library = new Library();
        library.addBook(BOOK_1, SHELF_1);
        library.addBook(BOOK_2, SHELF_2);
        library.addBook(BOOK_3, SHELF_3);

        library.printAllBooks();

        assertEquals(ALL_BOOK_INFO, outContent.toString());

        System.setOut(originalOut);
    }
}