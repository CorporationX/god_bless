package faang.school.godbless;

import org.junit.jupiter.api.Test;

import static faang.school.godbless.BookService.*;
import static faang.school.godbless.Main.bookShelfMap;
import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    @Test
    void addBookTest() {
        assertEquals(bookShelfMap.size(), 4);

        addBook(new Book("test", "test", 9999), "test");
        assertEquals(bookShelfMap.size(), 5);

        addBook(new Book("test", "test", 9999), "test");
        assertEquals(bookShelfMap.size(), 5);
    }

    @Test
    void deleteBookTest() {
        assertEquals(bookShelfMap.size(), 4);

        deleteBook("Clean code", "Martin", 2020);
        assertEquals(bookShelfMap.size(), 3);

        deleteBook("Clean code", "Martin", 2020);
        assertEquals(bookShelfMap.size(), 3);
    }

    @Test
    void findBookAndPrintGenreByInfoBookTest() {
        Book book = new Book("Sherlok", "Doyle", 2023);
        assertEquals(findBookAndPrintGenreByInfoBook("Sherlok", "Doyle", 2023), book);

        assertNull(findBookAndPrintGenreByInfoBook("herlok", "Doyle", 2023));
    }
}