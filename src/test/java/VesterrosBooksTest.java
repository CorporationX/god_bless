import org.example.app.Main;
import org.example.model.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VesterrosBooksTest {
    @Test
    @DisplayName("test to equals of the books hashcode and equals method")
    void testToEqualsOfTheBook() {
        Book book1 = new Book("title1", "author1", 1901);
        Book book2 = new Book("title1", "author1", 1901);
        Book book3 = new Book("title7", "author7", 1903);

        boolean areBooksEqualsTest1 = book1.hashCode() == book2.hashCode();
        boolean areBooksEqualsTest2 = book3.hashCode() == book2.hashCode();
        boolean testFunctionEquals1 = book2.equals(book1);
        boolean testFunctionEquals2 = book2.equals(book3);

        assertTrue(areBooksEqualsTest1);
        assertFalse(areBooksEqualsTest2);
        assertTrue(testFunctionEquals1);
        assertFalse(testFunctionEquals2);
    }

    @Test
    @DisplayName("test to add book")
    void testToAddBookToLibrary() {
        int currentSizeOfBooksInVesterros = Main.books.size();
        Book newBook = new Book("title10", "author10", 1910);
        String placeOfTheNewBook = "place of the new book";

        Main.addBook(newBook, placeOfTheNewBook);

        assertEquals(++currentSizeOfBooksInVesterros, Main.books.size());
    }

    @Test
    @DisplayName("test to remove book")
    void testToRemoveBookFromLibrary() {
        int currentSizeOfBooksInVesterros = Main.books.size();
        Book removingBook = new Book("title1", "author1", 1905);

        Main.removeBook(
                removingBook.getTitle(),
                removingBook.getAuthor(),
                removingBook.getYear());

        assertEquals(currentSizeOfBooksInVesterros - 1, Main.books.size());
    }

    @Test
    @DisplayName("test to find place of the book")
    void testToFindBookPlace() {
        Book findingBook = new Book("title2", "author2", 1922);
        String placeOfTheBook = Main.books.get(findingBook);

        String place = Main.findBookPlace(
                findingBook.getTitle(),
                findingBook.getAuthor(),
                findingBook.getYear()
        );

        assertSame(placeOfTheBook, place);
        assertThrows(IllegalArgumentException.class, () -> {
            Main.findBookPlace("unknownTitle", "unknownAuthor", 1992);
        });
    }
}
