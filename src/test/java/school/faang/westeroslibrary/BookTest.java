package school.faang.westeroslibrary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static school.faang.westeroslibrary.Main.library;

public class BookTest {

    @Test
    void addAndGetAndRemoveBookFromLibrary() {
        library.put(new Book("book5", "auhtor4", 2005), "b3");
        assertEquals(library.get(new Book("book5", "auhtor4", 2005)), "b3");

        library.remove(new Book("book5", "auhtor4", 2005));
        assertNull(library.get(new Book("book5", "auhtor4", 2005)));
    }

    @Test
    void textEquals() {
        library.put(new Book("book5", "auhtor4", 2005), "b3");

        assertNull(library.get(new Book("book6", "auhtor4", 2005)));
        assertNull(library.get(new Book("book5", "auhtor5", 2005)));
        assertNull(library.get(new Book("book5", "auhtor4", 2006)));
        assertNull(library.get(new Book("book6", "auhtor5", 2006)));

        library.remove(new Book("book5", "auhtor4", 2005), "b3");
    }

    @Test
    void overrideBookPlaceInLibrary() {
        library.put(new Book("book5", "auhtor4", 2005), "b3");
        assertEquals(library.get(new Book("book5", "auhtor4", 2005)), "b3");
        library.put(new Book("book5", "auhtor4", 2005), "b4");
        assertEquals(library.get(new Book("book5", "auhtor4", 2005)), "b4");
        library.remove(new Book("book5", "auhtor4", 2005));
    }

    @Test
    void nullBookPlace() {
        String bookPlace = Main.getBookPlace("book5", "auhtor4", 2005);
        assertEquals(bookPlace, "");
    }
}
