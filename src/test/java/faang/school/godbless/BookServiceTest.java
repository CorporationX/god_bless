package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static faang.school.godbless.BookService.*;
import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    public static HashMap<Book, String> bookShelfMapTest = new HashMap<>();

    @BeforeEach
    void init() {
        bookShelfMapTest.put(new Book("Clean code", "Martin", 2020), "Programming");
        bookShelfMapTest.put(new Book("Microservices", "Richardson", 2022), "Programming");
        bookShelfMapTest.put(new Book("Apache Kafka", "Krit", 2024), "Programming");
        bookShelfMapTest.put(new Book("Sherlok", "Doyle", 2023), "Artistic");
    }

    @Test
    void addBookTest() {
        Book book = new Book("test", "test", 9999);
        assertEquals(bookShelfMapTest.size(), 4);

        addBook(book, "test", bookShelfMapTest);
        assertEquals(bookShelfMapTest.size(), 5);

        addBook(book, "test", bookShelfMapTest);
        assertEquals(bookShelfMapTest.size(), 5);

        Book nullBook = null;
        assertThrows(IllegalArgumentException.class,
                () -> addBook(nullBook, "test", bookShelfMapTest),
                "Book can't be null");
    }

    @Test
    void deleteBookTest() {
        Book book = new Book("Clean code", "Martin", 2020);
        assertEquals(bookShelfMapTest.size(), 4);

        deleteBook(book, bookShelfMapTest);
        assertEquals(bookShelfMapTest.size(), 3);

        deleteBook(book, bookShelfMapTest);
        assertEquals(bookShelfMapTest.size(), 3);
    }

    @Test
    void findBookAndPrintGenreByInfoBookTest() {
        Book book = new Book("Sherlok", "Doyle", 2023);
        assertEquals(findBookAndPrintGenreByInfoBook(book, bookShelfMapTest), new Book("Sherlok", "Doyle", 2023));

        book = new Book("Sherlok", "Doyle", 2020);
        assertNull(findBookAndPrintGenreByInfoBook(book, bookShelfMapTest));
    }
}