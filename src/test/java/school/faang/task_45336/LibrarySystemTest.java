package school.faang.task_45336;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LibrarySystemTest {

    LibrarySystem library = new LibrarySystem(new HashMap<Book, String>());

    @Test
    void testSuccessAddBook() {
        assertDoesNotThrow(() -> library.addBook("Лолита", "Владимир Набоков", 1955, "93"));
    }

    @Test
    void testAddBookThrowException() {
        assertThrows(IllegalArgumentException.class, () -> library.addBook("", "Владимир Набоков", 1955, "93"));
        assertThrows(IllegalArgumentException.class, () -> library.addBook(null, "Владимир Набоков", 1955, "93"));
        assertThrows(IllegalArgumentException.class, () -> library.addBook("Лолита", null, 1955, "93"));
        assertThrows(IllegalArgumentException.class, () -> library.addBook("Лолита", "", 1955, "93"));
    }

    @Test
    void testSuccessRemoveBook() {
        library.addBook("Лолита", "Владимир Набоков", 1955, "93");
        assertTrue(() -> library.removeBook("Лолита", "Владимир Набоков", 1955));
    }

    @Test
    void testFailRemoveBook() {
        library.addBook("Лолита", "Владимир Набоков", 1955, "93");
        assertFalse(() -> library.removeBook("Лолита", "Владимир", 1955));
        assertFalse(() -> library.removeBook("", "Владимир", 1955));
    }

    @Test
    void testSuccessFindBook() {
        library.addBook("Лолита", "Владимир Набоков", 1955, "93");
        assertEquals("93", library.findBook("Лолита", "Владимир Набоков", 1955));
    }

    @Test
    void testFailFindBook() {
        library.addBook("Лолита", "Владимир Набоков", 1955, "93");
        assertEquals("Книга не найдена!", library.findBook("Не помню название", "Владимир Набоков", 1955));
        assertEquals("Такой книги не существует!", library.findBook(null, "Владимир Набоков", 1955));
        assertEquals("Такой книги не существует!", library.findBook("Лолита", null, 1955));
    }
}