package vesteros.library;

import faang.school.godbless.vesteros.library.Book;
import faang.school.godbless.vesteros.library.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    void testAdd() {
        Book book = new Book("Stones", "Mr. Jagger", 1520);
        Assertions.assertFalse(Main.bookPlace.containsKey(book));
        int size = Main.bookPlace.size();

        Main.add(book, "5 room, 4 shelf");
        Assertions.assertTrue(Main.bookPlace.containsKey(book));
        Assertions.assertEquals(size + 1, Main.bookPlace.size());
    }

    @Test
    void testRemove() {
        Book book = new Book("Dragons", "Mr. Docker", 1287);
        Assertions.assertTrue(Main.bookPlace.containsKey(book));
        int size = Main.bookPlace.size();

        Main.remove("Dragons", "Mr. Docker", 1287);
        Assertions.assertFalse(Main.bookPlace.containsKey(book));
        Assertions.assertEquals(size - 1, Main.bookPlace.size());
    }
}
