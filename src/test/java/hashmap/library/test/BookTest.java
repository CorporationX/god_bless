package hashmap.library.test;

import hasmap.library.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookTest {
    @Test
    @DisplayName("Create book with null title")
    void bookTest_createBookWithNullTitle() {
        assertThrows(NullPointerException.class, () -> new Book(null, "test", 1));
    }

    @Test
    @DisplayName("Create book with null author")
    void bookTest_createBookWithNullAuthor() {
        assertThrows(NullPointerException.class, () -> new Book("test", null, 1));
    }
}
