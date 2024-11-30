package faang.school.godbless.googleTranslater;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DictionaryProcessorTest {
    private Map<String, String> dictionary = new HashMap<>();
    private BiConsumer<String, String> addWordToDictionary = (word, wordTranslation) -> dictionary.put(word, wordTranslation);

    @Test
    public void testValidWordAndTranslation() {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);

        assertTrue(dictionary.containsKey("привет"));
        assertEquals("hello", dictionary.get("привет"));
    }

    @Test
    public void testInvalidWord() {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        dictionaryProcessor.processWord("", "world", addWordToDictionary);

        assertTrue(dictionary.isEmpty());
    }

    @Test
    public void testInvalidTranslation() {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        dictionaryProcessor.processWord("программирование", null, addWordToDictionary);

        assertTrue(dictionary.isEmpty());
    }

}