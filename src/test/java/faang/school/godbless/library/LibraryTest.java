package faang.school.godbless.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private static Library library;

    @Test
    void shouldAddRemoveSearchBook() {
        library = new Library();
        Book book1 = new Book("War and Peace", "Leo Tolstoy", 1867);
        library.addBook(book1, "russian lit");
        assertEquals("russian lit", library.searchBook("War and Peace", "Leo Tolstoy", 1867));
        library.removeBook("War and Peace", "Leo Tolstoy", 1867);
        assertNull(library.searchBook("War and Peace", "Leo Tolstoy", 1867));
    }

    @Test
    void shouldGiveBookList() {
        library = new Library();
        Book book1 = new Book("War and Peace", "Leo Tolstoy", 1867);
        library.addBook(book1, "russian lit");
        Book book2 = new Book("1984", "George Orwell", 1949);
        library.addBook(book2, "english lit");
        String expected = "Book(title=1984, author=George Orwell, year=1949):english lit\n" + "Book(title=War and " +
                "Peace, author=Leo Tolstoy, year=1867):russian lit\n";
        assertEquals(expected, library.bookList());
    }
}