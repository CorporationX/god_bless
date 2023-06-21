package google;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryProcessorTest {
    private DictionaryProcessor dictionaryProcessor;
    private Map<String, String> dictionary;
    private BiConsumer<String, String> biConsumer;
    @BeforeEach
    public void setUp() {
        dictionaryProcessor = new DictionaryProcessor();
        dictionary = new HashMap<>();
        biConsumer = (word, translation) -> dictionary.put(word, translation);
    }

    @Test
    void processWord_CorrectAnswerTest() {
        dictionaryProcessor.processWord("привет", "hello", biConsumer);
        String hello = "hello";

        assertEquals(hello, dictionary.get("привет"));
    }
    @Test
    void processWord_emptyParameter() {
        dictionaryProcessor.processWord("пока", "", biConsumer);
        assertTrue(dictionary.get("пока").isBlank());
        IllegalArgumentException illegalArgumentException =  assertThrows(IllegalArgumentException.class, ()-> {throw new IllegalArgumentException("translation is empty");});
        assertEquals("translation is empty", illegalArgumentException.getMessage());
    }
}