package faang.school.godbless.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainLibraryTest {

    @Test
    void testAddBook() {
        var library = new MainLibrary();
        var book = new Book("A Song of Ice and Fire", "Martin", 1996);
        var position = "1A";

        Assertions.assertEquals(0, library.getLibrary().size());

        library.addBook(book, position);
        Assertions.assertEquals(1, library.getLibrary().size());
    }

    @Test
    void testRewriteBook() {
        var library = new MainLibrary();
        var book = new Book("A Song of Ice and Fire", "Martin", 1996);
        var position1 = "1A";
        var position2 = "1B";

        Assertions.assertEquals(0, library.getLibrary().size());

        library.addBook(book, position1);
        Assertions.assertEquals(1, library.getLibrary().size());
        Assertions.assertEquals(position1, library.searchBook(book.title(), book.author(), book.year()));

        library.addBook(book, position2);
        Assertions.assertEquals(1, library.getLibrary().size());
        Assertions.assertEquals(position2, library.searchBook(book.title(), book.author(), book.year()));
    }


    @Test
    void testSearchBook() {
        var library = new MainLibrary();
        var book1 = new Book("A Song of Ice and Fire", "Martin", 1996);
        var book2 = new Book("History", "Author", 2002);
        var book3 = new Book("Book", "User", 2003);
        var position1 = "1A";
        var position2 = "1B";
        var position3 = "1C";

        Assertions.assertEquals(0, library.getLibrary().size());

        library.addBook(book1, position1);
        library.addBook(book2, position2);
        library.addBook(book3, position3);

        Assertions.assertEquals(3, library.getLibrary().size());
        Assertions.assertEquals(position1, library.searchBook(book1.title(), book1.author(), book1.year()));
    }

    @Test
    void testFailSearchBook() {
        var library = new MainLibrary();
        var book = new Book("A Song of Ice and Fire", "Martin", 1996);

        Assertions.assertEquals(0, library.getLibrary().size());

        Assertions.assertNull(library.searchBook(book.title(), book.author(), book.year()));
    }

    @Test
    void testRemoveBook() {
        var library = new MainLibrary();
        var book1 = new Book("A Song of Ice and Fire", "Martin", 1996);
        var book2 = new Book("History", "Author", 2002);
        var book3 = new Book("Book", "User", 2003);
        var position1 = "1A";
        var position2 = "1B";
        var position3 = "1C";

        Assertions.assertEquals(0, library.getLibrary().size());

        library.addBook(book1, position1);
        library.addBook(book2, position2);
        library.addBook(book3, position3);
        Assertions.assertEquals(3, library.getLibrary().size());
        Assertions.assertEquals(position1, library.searchBook(book1.title(), book1.author(), book1.year()));

        library.removeBook(book1.title(), book1.author(), book1.year());
        Assertions.assertEquals(2, library.getLibrary().size());
        Assertions.assertNull(library.searchBook(book1.title(), book1.author(), book1.year()));
    }

    @Test
    void testFailRemoveBook() {
        var library = new MainLibrary();
        var book = new Book("A Song of Ice and Fire", "Martin", 1996);

        Assertions.assertEquals(0, library.getLibrary().size());

        Assertions.assertDoesNotThrow(()->library.removeBook(book.title(), book.author(), book.year()));
    }

}
