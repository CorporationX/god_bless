package faang.schoole.godbless.googleTranslate;

import faang.school.godbless.DictionaryProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class googleTranslateTest {
    DictionaryProcessor dictionaryProcessor;
    Map<String, String> dictionary;
    @BeforeEach
    public void setUp() {
        dictionaryProcessor = new DictionaryProcessor();
        dictionary = new HashMap<>();
    }

    @Test
    public void testAddWords() {
        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);

        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);

        assertEquals(3, dictionary.size());
        assertEquals("hello", dictionary.get("привет"));
        assertEquals("world", dictionary.get("мир"));
        assertEquals("programming", dictionary.get("программирование"));
    }

}
