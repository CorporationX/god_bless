package libraryOfWesteros;

import mod1sp12.libraryOfWesteros.Book;
import mod1sp12.libraryOfWesteros.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    @DisplayName("Adding book to library test")
    void addBookToLibraryTest() {
        String title = "Atlas Shrugged";
        String author = "Ayn Rand";
        int year = 1957;

        Main.addBookToLibrary(title, author, year);

        assertTrue(Main.getLibrary().containsKey(new Book("Atlas Shrugged", "Ayn Rand", 1957)));
        assertEquals("number of shelf: 4", Main.getLibrary().get(new Book("Atlas Shrugged", "Ayn Rand", 1957)));
    }

    @Test
    @DisplayName("Remove book from library test")
    void removeBookFromLibraryTest() {
        String title = "Atlas Shrugged";
        String author = "Ayn Rand";
        int year = 1957;

        Main.addBookToLibrary(title, author, year);
        Main.removeBookFromLibrary(title, author, year);

        assertFalse(Main.getLibrary().containsKey(new Book("Atlas Shrugged", "Ayn Rand", 1957)));
    }

    @Test
    @DisplayName("Get shelf in library test")
    void getShelfInLibraryTest() {
        String title = "Harry Potter";
        String author = "J.K. Rowling";
        int year = 1997;

        String shelf = Main.getShelfInLibrary(title, author, year);

        assertEquals("number of shelf: 1", shelf);
    }
}
