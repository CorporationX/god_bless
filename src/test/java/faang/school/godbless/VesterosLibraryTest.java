package faang.school.godbless;

import faang.school.godbless.dolbahlop.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class VesterosLibraryTest {
    Book book1 = new Book("The Enigmatic Artifact", "Elrik Tendervind", 1234);
    Book book2 = new Book("Chronicles of the Forgotten Lands", "Liana Starson", 1356);
    Book book3 = new Book("Secrets of the Magical Forest", "Arden Moonglow", 1478);
    Book book4 = new Book("Through the Gates of Illiria", "Elarion Silverblade", 1590);

    VesterosLibrary vesterosLibrary;

    @BeforeEach
    void setUp() {
        vesterosLibrary = new VesterosLibrary(new HashMap<>(Map.of(
                book1, "1",
                book2, "2",
                book3, "3"
        )));
    }

    @Test
    void testAddNewBookAndFindBook() {
        String location = "A";
        vesterosLibrary.addNewBook(book4, location);
        assertEquals(location, vesterosLibrary.findBook(book4.getTitle(), book4.getAuthor(), book4.getYear()));
    }

    @Test
    void testDeleteNewBook() {
        System.out.println(vesterosLibrary.findAllBooks());
        vesterosLibrary.addNewBook(book4, "A");
        vesterosLibrary.deleteBook(book4.getTitle(), book4.getAuthor(), book4.getYear());
        System.out.println(vesterosLibrary.findAllBooks());
        assertNull(vesterosLibrary.findBook(book4.getTitle(), book4.getAuthor(), book4.getYear()));
    }

    @Test
    void testFindAllBooks() {
        List<String> expectedList = new ArrayList<>(List.of(
                book1 + " Location: " + "1",
                book2 + " Location: " + "2",
                book3 + " Location: " + "3"
        ));
        Collections.sort(expectedList);
        List<String> actualList = vesterosLibrary.findAllBooks();
        Collections.sort(actualList);

        assertEquals(expectedList, actualList);
    }
}
