package faang.school.godbless.googleTranslateTest;
import faang.school.godbless.sprint2.googleTranslate.DictionaryProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.*;
public class DictionaryProcessorTest {
    DictionaryProcessor dictionaryProcessor;
    Map<String, String> dictionary;
    BiConsumer<String, String> addWordToDictionary;
    @BeforeEach
    public void init(){
        dictionaryProcessor = new DictionaryProcessor();
        dictionary = new HashMap<>();
        addWordToDictionary = (word, translation) -> dictionary.put(word, translation);
    }
    @Test
    public void DictionaryProcessorTest() {
        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        String expected = "hello";
        assertEquals(expected,dictionary.get("привет"));
    }
}
