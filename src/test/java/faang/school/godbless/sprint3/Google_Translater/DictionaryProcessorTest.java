package faang.school.godbless.sprint3.Google_Translater;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryProcessorTest {
    Map<String, String> dictionary = new HashMap<>();
    String word = "Hello";
    String translateWord = "Привет";
    DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

    @Test
    void testProcessWordContains() {
        dictionaryProcessor.processWord(word, translateWord, (a, b) -> dictionary.put(a, b));
        Assertions.assertTrue(dictionary.containsKey(word));
    }

    @Test
    void testProcessWordValue() {
        dictionaryProcessor.processWord(word, translateWord, (a, b) -> dictionary.put(a, b));
        Assertions.assertEquals(translateWord, dictionary.get(word));
    }

    @Test
    void testProcessWordSize() {
        dictionaryProcessor.processWord(word, translateWord, (a, b) -> dictionary.put(a, b));
        Assertions.assertEquals(1, dictionary.size());
    }

}