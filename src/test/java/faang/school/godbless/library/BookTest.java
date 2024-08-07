package faang.school.godbless.library;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
class BookTest {

    @Test
    void booksEqualityTest(){
        Book book1 = new Book("Love Sucks", "Sage Collins", 2012);
        Book book2 = new Book("Love Sucks", "Sage Collins", 2012);

        assertTrue(book1.equals(book2));
    }

    @Test
    void bookAdditionTest(){
        HashMap<Book, String> booksList = new HashMap<>();
        Book book1 = new Book("Hostile", "Nicole Dykes", 2022);
        Book book2 = new Book("Brokeback Mountain", "Annie Proulx", 1997);

        Main.addBook(booksList, book1, "A1");
        Main.addBook(booksList, book2, "B1");

        assertEquals(2, booksList.size());
    }

    void bookDeletionTest(){
        HashMap<Book, String> booksList = new HashMap<>();
        Book book1 = new Book("Hostile", "Nicole Dykes", 2022);
        Book book2 = new Book("Brokeback Mountain", "Annie Proulx", 1997);

        Main.addBook(booksList, book1, "A1");
        Main.addBook(booksList, book2, "B1");

        Main.deleteBook(booksList, "Hostile", "Nicole Dykes", 2022);

        assertEquals(1, booksList.size());
    }

    @Test
    void existingBookAdditionTest(){
        HashMap<Book, String> booksList = new HashMap<>();
        Book book1 = new Book("Hostile", "Nicole Dykes", 2022);
        Book book2 = new Book("Hostile", "Nicole Dykes", 2022);

        Main.addBook(booksList, book1, "A1");
        Main.addBook(booksList, book2, "B1");

        assertEquals("The book Hostile by Nicole Dykes. Year: 2022 is already exists", Main.addBook(booksList, book2, "B1"));
    }

    @Test
    void bookListTest(){
        HashMap<Book, String> booksList = new HashMap<>();
        Book book1 = new Book("Hostile", "Nicole Dykes", 2022);
        Book book2 = new Book("Brokeback Mountain", "Annie Proulx", 1997);

        Main.addBook(booksList, book1, "A1");
        Main.addBook(booksList, book2, "B1");

        Main.getBookList(booksList);
    }
}