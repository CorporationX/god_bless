import faang.school.godbless.googleTranslater.DictionaryProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.*;

public class DictionaryProcessorTest {
    DictionaryProcessor dictionaryProcessor;
    String word;
    String translatedWord;
    Map<String, String> dictionary;
    BiConsumer<String, String> addWordToDictionary;
    @BeforeEach
    public void init() {
        dictionaryProcessor = new DictionaryProcessor();
        dictionary = new HashMap<>();
        addWordToDictionary = (word, translation) -> dictionary.put(word, translation);
    }
    @Test
    public void DictionaryProcessorTest() {
        dictionaryProcessor.processWord("Hello", "Здрасте", addWordToDictionary);
        String expected = "Здрасте";
        assertEquals(expected, dictionary.get("Hello"));
    }
    @Test
    public void addWordToDictionaryTest() {
        dictionaryProcessor.processWord("Hello", "Здрасте", addWordToDictionary);
        int size = dictionary.size();
        int expected = 1;
        assertEquals(expected, size);
    }

}
