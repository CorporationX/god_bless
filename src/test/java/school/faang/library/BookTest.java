package school.faang.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static school.faang.library.Book.addBook;
import static school.faang.library.Book.deleteBook;

public class BookTest {

    @Test
    public void testAddBook() {
        Map<Book, String> books = new HashMap<>();
        Book book = new Book("Book Title3", "Author3", 1920);

//        add book to an empty map
        addBook(books, book, "3");

        assertEquals(1, books.size());
        assertEquals("3", books.get(book));

//        add book to non-empty map - key already present, value will be updated, size the same
        addBook(books, book, "13");
        assertEquals(1, books.size());
        assertEquals("13", books.get(book));

//        add book to non-empty map - new key
        Book book2 = new Book("Book Title1", "Author1", 1900);
        addBook(books, book2, "28");
        assertEquals(2, books.size());
        assertEquals("28", books.get(book2));
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""})
    public void testAddBookLocationNullEmpty(String location) {
        Map<Book, String> books = new HashMap<>();
        Book book = new Book("Book Title1", "Author1", 1910);

//        add book to an empty map
        addBook(books, book, location);

        assertEquals(1, books.size());
        assertEquals(location, books.get(book));
    }

    @Test
    public void testAddBookBookNull() {
        Map<Book, String> books = new HashMap<>();

//        add book to an empty map
        addBook(books, null, "1");

        assertEquals(1, books.size());
        assertEquals("1", books.get(null));
    }

    @Test
    public void testDeleteBook(){
        Book book1 = new Book("Book Title1", "Author1", 1900);
        Book book2 = new Book("Book Title2", "Author2", 1910);
        Map<Book, String> books = new HashMap<>();
        books.put(book1, "1");
        books.put(book2, "2");

        deleteBook(books,book1);
        assertEquals(1, books.size());
        assertNull(books.get(book1));
    }

}
