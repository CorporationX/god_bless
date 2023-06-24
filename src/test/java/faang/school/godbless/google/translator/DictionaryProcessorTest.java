package faang.school.godbless.google.translator;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DictionaryProcessorTest {

    @Test
    public void testDictionaryProcessor() {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addWordToDictionary = dictionary::put;

        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);

        assertEquals(3, dictionary.size());
        assertEquals("hello", dictionary.get("привет"));
        assertEquals("world", dictionary.get("мир"));
        assertEquals("programming", dictionary.get("программирование"));
    }
}