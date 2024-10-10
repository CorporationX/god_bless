package school.faang.google.translate;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DictionaryProcessorTest {

    private Map<String, String> dictionary;
    private BiConsumer<String, String> addWordToDictionary;

    @BeforeEach
    public void setUp() {
        dictionary = new HashMap<>();
        addWordToDictionary = (word, translation) -> dictionary.put(word, translation);
    }

    @Test
    public void addWordToDictionaryTest() {
        Map<String, String> expected = Map.of(
                "привет", "hello",
                "мир", "world",
                "программирование", "programming"
        );

        DictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        DictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        DictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);

        assertEquals(expected, dictionary);
        assertEquals(expected.size(), dictionary.size());
    }
}
