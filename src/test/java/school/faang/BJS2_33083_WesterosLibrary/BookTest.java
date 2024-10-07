package school.faang.BJS2_33083_WesterosLibrary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BookTest {
    @Test
    @DisplayName("Testing the creation of Book object with valid data")
    void testConstructorWithValidData() {
        String title = "The Great Gatsby";
        String author = "F. Scott Fitzgerald";
        int year = 1925;
        Book theGreatGatsby = new Book(title, author, year);

        assertEquals(title, theGreatGatsby.getTitle());
        assertEquals(author, theGreatGatsby.getAuthor());
        assertEquals(year, theGreatGatsby.getYear());
    }

    @Test
    @DisplayName("Testing the creation of Book object with Empty title")
    void testConstructorWithEmptyTitle() {
        String title = "      ";
        String author = "F. Scott Fitzgerald";
        int year = 1925;

        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> new Book(title, author, year));
        assertEquals("Invalid info.",argumentException.getMessage());
    }

    @Test
    @DisplayName("Testing the creation of Book object with Null title")
    void testConstructorWithNullTitle() {
        String title = null;
        String author = "F. Scott Fitzgerald";
        int year = 1925;

        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> new Book(title, author, year));
        assertEquals("Invalid info.",argumentException.getMessage());
    }

    @Test
    @DisplayName("Testing the creation of Book object with Empty author")
    void testConstructorWithEmptyAuthor() {
        String title = "The Great Gatsby";
        String author = "   ";
        int year = 1925;

        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> new Book(title, author, year));
        assertEquals("Invalid info.",argumentException.getMessage());
    }

    @Test
    @DisplayName("Testing the creation of Book object with Null author")
    void testConstructorWithNullAuthor() {
        String title = "The Great Gatsby";
        String author = null;
        int year = 1925;

        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> new Book(title, author, year));
        assertEquals("Invalid info.",argumentException.getMessage());
    }

    @Test
    @DisplayName("Testing the creation of Book object with Invalid year")
    void testConstructorWithInvalidYear() {
        String title = "The Great Gatsby";
        String author = "F. Scott Fitzgerald";
        int year = 124;

        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> new Book(title, author, year));
        assertEquals("Invalid year of publication. Must be at least 1564.",argumentException.getMessage());
    }
}