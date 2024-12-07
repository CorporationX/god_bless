package school.faang.bjs245335;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.bjs245335.books.BooksData;
import school.faang.bjs245335.books.Locations;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystemTest {
    private static final Map<Book, String> BOOKS = new HashMap<>();
    private static final LibrarySystem LIBRARY_SYSTEM = new LibrarySystem(BOOKS);

    @BeforeEach
    public void setUp() {
        BOOKS.clear();
        addBookToMap(BooksData.BOOK1, Locations.LOCATION1.name());
        addBookToMap(BooksData.BOOK2, Locations.LOCATION2.name());
        addBookToMap(BooksData.BOOK3, Locations.LOCATION3.name());
    }

    @Test
    public void testAddBook() {
        BooksData book = BooksData.BOOK4;
        LIBRARY_SYSTEM.addBook(book.getTitle(),
                book.getAuthor(),
                book.getYear(),
                Locations.LOCATION1.name());
        Assertions.assertTrue(BOOKS.containsKey(BooksData.BOOK4.createBook()));
    }

    @Test
    public void testAddBookWithNullLocation() {
        BooksData book = BooksData.BOOK4;
        LIBRARY_SYSTEM.addBook(book.getTitle(),
                book.getAuthor(),
                book.getYear(),
                null);
        Assertions.assertTrue(BOOKS.containsKey(BooksData.BOOK4.createBook()));
    }

    @Test
    public void testRemoveBook() {
        BooksData book = BooksData.BOOK3;
        LIBRARY_SYSTEM.removeBook(book.getTitle(),
                book.getAuthor(),
                book.getYear());
        Assertions.assertFalse(BOOKS.containsKey(BooksData.BOOK3.createBook()));
    }

    @Test
    public void testFindBook() {
        BooksData book = BooksData.BOOK2;
        String location = LIBRARY_SYSTEM.findBook(book.getTitle(),
                book.getAuthor(),
                book.getYear());
        Assertions.assertEquals(Locations.LOCATION2.name(), location);
    }

    @Test
    public void testFindBookWithNullLocation() {
        BooksData book = BooksData.BOOK4;
        addBookToMap(book, null);
        String location = LIBRARY_SYSTEM.findBook(book.getTitle(),
                book.getAuthor(),
                book.getYear());
        Assertions.assertNull(location);
    }

    private void addBookToMap(BooksData booksData, String location) {
        BOOKS.put(booksData.createBook(), location);
    }
}
