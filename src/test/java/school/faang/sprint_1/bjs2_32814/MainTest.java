package school.faang.sprint_1.bjs2_32814;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static school.faang.sprint_1.bjs2_32814.Main.SPLIT_RULE;
import static school.faang.sprint_1.bjs2_32814.Main.URL_INDEX;
import static school.faang.sprint_1.bjs2_32814.Main.WORD_INDEX;
import static school.faang.sprint_1.bjs2_32814.Main.indexWebPage;
import static school.faang.sprint_1.bjs2_32814.Main.searchByIndex;

public class MainTest {

    @BeforeEach
    public void setUp() {
        WORD_INDEX.clear();
        URL_INDEX.clear();
    }

    @Test
    void testIndexWebPage() {
        WebPage faangSchool = new WebPage("faang.school", "Java Bootcamp", "Учи Java, лодырь!");
        indexWebPage(faangSchool);

        assertTrue(WORD_INDEX.containsKey("учи"));
        assertTrue(WORD_INDEX.containsKey("java"));
        assertTrue(WORD_INDEX.containsKey("лодырь"));
    }

    @Test
    void testSearchByIndex() {
        WebPage faangSchool = new WebPage("faang.school", "Java Bootcamp", "Учи Java, лодырь!");
        WebPage school = new WebPage("school.ru", "Алгебра", "Учи алгебру, лодырь!");
        indexWebPage(faangSchool);
        indexWebPage(school);
        String[] faangSchoolWords = faangSchool.getContent().split(SPLIT_RULE);
        String[] schoolWords = school.getContent().split(SPLIT_RULE);

        for (String word : faangSchoolWords) {
            assertTrue(searchByIndex(word).contains(faangSchool));
        }

        for (String word : schoolWords) {
            assertTrue(searchByIndex(word).contains(school));
        }
    }

    @Test
    void testDeleteByUrl() {
        WebPage faangSchool = new WebPage("faang.school", "Java Bootcamp", "Учи Java, лодырь!");
        indexWebPage(faangSchool);
        Main.deleteByUrl("faang.school");
        Set<WebPage> result = Main.searchByIndex("java");

        assertTrue(result == null || !result.contains(faangSchool));
        assertFalse(URL_INDEX.containsKey("faang.school"));
    }
}
