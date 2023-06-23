package faang.school.godbless.Sprint3.Google_Translater;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static faang.school.godbless.Sprint3.Google_Translater.Main.dictionary;
import static org.junit.jupiter.api.Assertions.*;

class DictionaryProcessorTest {
    Map<String, String> dictionary = new HashMap<>();
    String word = "Hello";
    String translateWord = "Привет";
    DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

    @Test
    void testProcessWordContains() {
        dictionaryProcessor.processWord(word, translateWord, (a, b) -> dictionary.put(a, b));
        assertTrue(dictionary.containsKey(word));
    }

    @Test
    void testProcessWordValue() {
        dictionaryProcessor.processWord(word, translateWord, (a, b) -> dictionary.put(a, b));
        assertEquals(translateWord, dictionary.get(word));
    }

    @Test
    void testProcessWordSize() {
        dictionaryProcessor.processWord(word, translateWord, (a, b) -> dictionary.put(a, b));
        assertEquals(1, dictionary.size());
    }

}