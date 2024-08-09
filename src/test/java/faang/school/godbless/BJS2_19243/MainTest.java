package faang.school.godbless.BJS2_19243;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main;

    @BeforeEach
    void init() {
        main = new Main();
    }

    @Test
    void addBookTest() {
        Book book = new Book("Test title", "Test author", 2000);
        Integer sizeBefore = main.getAllBooks().size();
        main.addBook(book, "5");
        assertNotEquals(sizeBefore, main.getAllBooks().size());
        assertEquals(sizeBefore + 1, main.getAllBooks().size());
    }

    @Test
    void deleteExsistingBookTest() {
        int sizeBefore = main.getAllBooks().size();
        main.deleteBook("Ruslan and Liudmila", "Pushkin", 1735);
        assertEquals(sizeBefore - 1, main.getAllBooks().size());
    }

    @Test
    void deleteNotExsistingBookTest() {
        int sizeBefore = main.getAllBooks().size();
        assertThrows(NoSuchElementException.class, () -> main.deleteBook("No such book", "author", 1000));
        assertEquals(sizeBefore, main.getAllBooks().size());
    }

    @Test
    void findBookShelfTest() {
        String result = main.findBookShelf("Ruslan and Liudmila", "Pushkin", 1735);
        assertEquals("Your book is on 1 shelf", result);
    }

    @Test
    void findNotExistingBookTest() {
        String result = main.findBookShelf("No such book", "author", 1000);
        assertEquals("There is no such book in library", result);
    }

    @Test
    void getAllBooksTest() {
        List<String> result = main.getAllBooks();
        assertEquals(3, result.size());
        assertTrue(result.contains("Book{title='Crime and punishment', author='Dostoevskii', year=1835}, shelter: 2"));
    }
}