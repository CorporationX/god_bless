package school.faang.sprint_1.bjs2_33038;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static school.faang.sprint_1.bjs2_33038.Main.addBook;
import static school.faang.sprint_1.bjs2_33038.Main.deleteBook;
import static school.faang.sprint_1.bjs2_33038.Main.findBook;
import static school.faang.sprint_1.bjs2_33038.Main.library;
import static school.faang.sprint_1.bjs2_33038.Main.printAllBooks;

class MainTest {
    private static Book bible;
    private static Book warAndPeace;
    private static Book crimeAndPunishment;

    @BeforeAll
    public static void setUp() {
        bible = new Book("Bible", "Jesus", 0);
        warAndPeace = new Book("Война и мир", "Толстой", 1867);
        crimeAndPunishment = new Book("Преступление и наказание", "Достоевский", 1866);
        library.putAll(Map.of(
                bible, "shelf_1",
                warAndPeace, "shelf_2",
                crimeAndPunishment, "shelf_1"
        ));
    }

    @Test
    void testAddBook() {
        Book testBook = new Book("Как пить воду", "Котик Семён", 2012);
        addBook(testBook, "Полка кота Семёна");
        assertTrue(library.containsKey(testBook));
    }

    @Test
    void testDeleteBook() {
        deleteBook("Bible", "Jesus", 0);
        assertFalse(library.containsKey(bible));
    }

    @Test
    void testFindBook() {
        assertEquals("shelf_2", findBook("Война и мир", "Толстой", 1867));
    }

    @Test
    void testPrintAllBooks() {
        printAllBooks();
    }
}