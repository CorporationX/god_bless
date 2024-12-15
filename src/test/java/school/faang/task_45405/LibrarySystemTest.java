package school.faang.task_45405;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibrarySystemTest {
    private String captureOutput(Runnable action) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        action.run();

        System.setOut(originalOut);
        return outputStream.toString().trim();
    }

    @Test
    @DisplayName("addBook: adding a new book should increase the map size")
    void addBook_newBook_increasesMapSize() {
        // Arrange
        LibrarySystem librarySystem = new LibrarySystem();

        // Act
        librarySystem.addBook("1984", "George Orwell", 1949, "A3");
        Map<Book, String> books = librarySystem.getBooks();

        // Assert
        assertAll("Verify book addition",
                () -> assertEquals(1, books.size(), "Map size should be 1"),
                () -> assertTrue(books.containsKey(new Book("1984", "George Orwell", 1949)),
                        "Map should contain the added book"),
                () -> assertEquals("A3", books.get(new Book("1984", "George Orwell", 1949)),
                        "Book should be located at 'A3'")
        );
    }

    @Test
    @DisplayName("removeBook: removing an existing book should decrease the map size")
    void removeBook_existingBook_decreasesMapSize() {
        // Arrange
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("1984", "George Orwell", 1949, "A3");

        // Act
        librarySystem.removeBook("1984", "George Orwell", 1949);

        // Assert
        Map<Book, String> books = librarySystem.getBooks();
        assertAll("Verify book removal",
                () -> assertEquals(0, books.size(), "Map size should be 0 after removal"),
                () -> assertFalse(books.containsKey(new Book("1984", "George Orwell", 1949)),
                        "Map should not contain the removed book")
        );
    }

    @Test
    @DisplayName("findBook: finding an existing book should return correct location")
    void findBook_existingBook_correctLocation() {
        // Arrange
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("1984", "George Orwell", 1949, "A3");

        // Act
        String output = captureOutput(() -> librarySystem.findBook("1984", "George Orwell", 1949));

        // Assert
        assertAll("Verify findBook output and state",
                () -> assertTrue(output.contains("Book found at: A3"), "Output should indicate the correct location"),
                () -> assertTrue(output.contains("details: Book"), "Output should contain book details")
        );
    }

    @Test
    @DisplayName("printAllBooks: should list all books")
    void printAllBooks_displaysAllBooks() {
        // Arrange
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("1984", "George Orwell", 1949, "A3");
        librarySystem.addBook("To Kill a Mockingbird", "Harper Lee", 1960, "A2");

        // Act
        String output = captureOutput(librarySystem::printAllBooks);

        // Assert
        assertAll("Verify printAllBooks output",
                () -> assertTrue(output.contains("is located at A3"), "Output should list '1984'"),
                () -> assertTrue(output.contains("is located at A2"), "Output should list 'To Kill a Mockingbird'"),
                () -> assertTrue(output.startsWith("Books in the library:"), "Output should start with header")
        );
    }

    @Test
    @DisplayName("findBook: trying to find a non-existing book should print an error message")
    void findBook_nonExistingBook_errorMessage() {
        // Arrange
        LibrarySystem librarySystem = new LibrarySystem();

        // Act
        String output = captureOutput(() -> librarySystem.findBook("Unknown Book", "Unknown Author", 2023));

        // Assert
        assertAll("Verify findBook output for non-existing book",
                () -> assertTrue(output.contains("Book not found"),
                        "Output should indicate that the book was not found")
        );
    }

    @Test
    @DisplayName("removeBook: trying to remove a non-existing book should print an error message")
    void removeBook_nonExistingBook_errorMessage() {
        // Arrange
        LibrarySystem librarySystem = new LibrarySystem();

        // Act
        String output = captureOutput(() -> librarySystem.removeBook("Unknown Book", "Unknown Author", 2023));

        // Assert
        assertAll("Verify removeBook output for non-existing book",
                () -> assertTrue(output.contains("Book not found"),
                        "Output should indicate that the book was not found")
        );
    }
}