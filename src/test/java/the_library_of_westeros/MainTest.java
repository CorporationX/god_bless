package the_library_of_westeros;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void addBook() {
        Main.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925), "2");

        assertEquals(Main.LIBRARY.size(), 1);
    }

    @Test
    void removeBook() {
        Main.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925), "2");
        assertEquals(Main.LIBRARY.size(), 2);
        Main.removeBook("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        assertEquals(Main.LIBRARY.size(), 1);
    }

    @Test
    void searchAndPrintInfoBook() {
        Main.addBook(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997), "2");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Main.searchAndPrintInfoBook("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997);

        assertEquals(
                "The book Book(title=Harry Potter and the Philosopher's Stone, author=J. K. Rowling, year=1997) is in the 2 shelf\n",
                outContent.toString()
        );

        System.setOut(originalOut);
    }

    @Test
    void printAllBooks() {
        Main.addBook(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997), "2");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Main.printAllBooks();

        assertEquals(
                "Book(title=Harry Potter and the Philosopher's Stone, author=J. K. Rowling, year=1997) is in the 2 shelf\n",
                outContent.toString()
        );

        System.setOut(originalOut);
    }
}