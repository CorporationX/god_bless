package faang.school.godbless.translator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDictionaryProcessor {
    private Map<String, String> dictionary;
    private DictionaryProcessor dictionaryProcessor;

    @BeforeEach
    public void setUp() {
        dictionaryProcessor = new DictionaryProcessor();
        dictionary = new HashMap<>();
    }

    @Test
    public void testAddWordToDictionary() {
        BiConsumer<String, String> addWordsToDictionary = (word, translateWord) -> dictionary.put(word, translateWord);
        dictionaryProcessor.processWord("Кот", "Cat", addWordsToDictionary);
        dictionaryProcessor.processWord("Собака", "Dog", addWordsToDictionary);
        assertEquals(dictionary.get("Кот"), "Cat");
        assertEquals(dictionary.get("Собака"), "Dog");
    }
}
