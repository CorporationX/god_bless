package faang.school.godbless.sprint3.google_translator;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DictionaryProcessorTest {
    private DictionaryProcessor dictionaryProcessor;
    private Map<String, String> dictionary;

    @BeforeEach
    void setDictionaryProcessorAndDictionary() {
        dictionaryProcessor = new DictionaryProcessor();
        dictionary = new HashMap<>();
    }

    @Test
    void processWord() {
        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);

        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);

        assertAll(() -> {
            assertEquals(dictionary.size(), 3);
            assertEquals(dictionary.get("привет"), "hello");
            assertEquals(dictionary.get("мир"), "world");
            assertEquals(dictionary.get("программирование"), "programming");
        });
    }
}