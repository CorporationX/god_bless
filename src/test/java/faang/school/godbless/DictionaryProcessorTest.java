package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DictionaryProcessorTest {
    Map<String, String> dictionary;
    DictionaryProcessor dictionaryProcessor;

    @BeforeEach
    void setUp() {
        dictionary = new HashMap<>();
        dictionaryProcessor = new DictionaryProcessor();
    }

    @Test
    void testProcessWord() {
        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);
        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);

        assertEquals(dictionary.size(), 3);
        assertEquals(dictionary.get("привет"), "hello");
    }
}