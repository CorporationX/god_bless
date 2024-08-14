package faang.school.godbless.westeroslibrary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMain {

    Main library;

    @BeforeEach
    void init() {
        library = new Main();
    }

    @Test
    @DisplayName("Main initialization")
    public void testInit() {
        Assertions.assertEquals(3, library.getAllBooks().size());
    }

    @Test
    @DisplayName("Add book")
    public void testAddBook() {
        library.addBook(new Book("title4", "place4", "2004"), "shelf4");

        Assertions.assertEquals(4, library.getAllBooks().size());
    }

    @Test
    @DisplayName("Delete book")
    public void testDelBook() {
        library.delBook("title4", "place4", "2004");

        Assertions.assertEquals(3, library.getAllBooks().size());
    }

    @Test
    @DisplayName("Get place")
    void testGetPlace() {
        assertEquals(library.getPlace("title1", "author1", "2001"), "shelf1");
    }

    @Test
    @DisplayName("Get all books")
    void testGetAllBooks() {
        assertTrue(library.getAllBooks().contains("title: Book(title=title3, author=author3, year=2003), place: shelf3"));
    }
}