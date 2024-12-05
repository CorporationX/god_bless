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
        LIBRARY_SYSTEM.addBook(BooksData.BOOK4.getTitle(),
                BooksData.BOOK4.getAuthor(),
                BooksData.BOOK4.getYear(),
                Locations.LOCATION1.name());
        Assertions.assertTrue(BOOKS.containsKey(BooksData.BOOK4.createBook()));
    }

    @Test
    public void testAddBookWithNullLocation() {
        LIBRARY_SYSTEM.addBook(BooksData.BOOK4.getTitle(),
                BooksData.BOOK4.getAuthor(),
                BooksData.BOOK4.getYear(),
                null);
        Assertions.assertTrue(BOOKS.containsKey(BooksData.BOOK4.createBook()));
    }

    @Test
    public void testRemoveBook() {
        LIBRARY_SYSTEM.removeBook(BooksData.BOOK3.getTitle(),
                BooksData.BOOK3.getAuthor(),
                BooksData.BOOK3.getYear());
        Assertions.assertFalse(BOOKS.containsKey(BooksData.BOOK3.createBook()));
    }

    @Test
    public void testFindBook() {
        String location = LIBRARY_SYSTEM.findBook(BooksData.BOOK2.getTitle(),
                BooksData.BOOK2.getAuthor(),
                BooksData.BOOK2.getYear());
        Assertions.assertEquals(Locations.LOCATION2.name(), location);
    }

    @Test
    public void testFindBookWithNullLocation() {
        addBookToMap(BooksData.BOOK4, null);
        String location = LIBRARY_SYSTEM.findBook(BooksData.BOOK4.getTitle(),
                BooksData.BOOK4.getAuthor(),
                BooksData.BOOK4.getYear());
        Assertions.assertNull(location);
    }


    private void addBookToMap(BooksData booksData, String location) {
        BOOKS.put(booksData.createBook(), location);
    }
}
