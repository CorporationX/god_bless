package school.faang.bjs2_32814;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @BeforeEach
    public void setUp() {
        Main.wordIndex.clear();
        Main.urlIndex.clear();
    }

    @Test
    void testIndexWebPage() {
        WebPage faangSchool = new WebPage("faang.school", "Java Bootcamp", "Учи Java, лодырь!");
        Main.indexWebPage(faangSchool);

        assertTrue(Main.wordIndex.containsKey("учи"));
        assertTrue(Main.wordIndex.containsKey("java"));
        assertTrue(Main.wordIndex.containsKey("лодырь"));
    }

    @Test
    void testSearchByIndex() {
        WebPage faangSchool = new WebPage("faang.school", "Java Bootcamp", "Учи Java, лодырь!");
        WebPage school = new WebPage("school.ru", "Алгебра", "Учи алгебру, лодырь!");
        Main.indexWebPage(faangSchool);
        Main.indexWebPage(school);

        assertEquals(2, Main.searchByIndex("учи").size());
        assertEquals(1, Main.searchByIndex("java").size());
    }

    @Test
    void testDeleteByUrl() {
        WebPage faangSchool = new WebPage("faang.school", "Java Bootcamp", "Учи Java, лодырь!");
        Main.indexWebPage(faangSchool);
        Main.deleteByUrl("faang.school");
        Set<WebPage> result = Main.searchByIndex("java");

        assertTrue(result == null || !result.contains(faangSchool));
        assertFalse(Main.urlIndex.containsKey("faang.school"));
    }
}
