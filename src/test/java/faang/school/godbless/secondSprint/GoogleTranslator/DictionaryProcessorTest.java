package faang.school.godbless.secondSprint.GoogleTranslator;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryProcessorTest {
    @Test
    public void testProcessWord() {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> biConsumer = dictionary::put;

        dictionaryProcessor.processWord("apple", "яблоко", biConsumer);
        dictionaryProcessor.processWord("orange", "апельсин", biConsumer);
        Map<String, String> expected = Map.of(
                "apple", "яблоко",
                "orange", "апельсин"
        );

        assertEquals(expected, dictionary);
    }
}