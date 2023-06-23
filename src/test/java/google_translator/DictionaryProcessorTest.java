package google_translator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DictionaryProcessorTest {
    private DictionaryProcessor dictionaryProcessor;
    private Map<String, String> dictionary;

    @BeforeEach
    public void setUp() {
        dictionaryProcessor = new DictionaryProcessor();
        dictionary = new HashMap<>();
    }

    @Test
    public void testProcessWord() {
        String word = "hello";
        String translation = "hola";
        BiConsumer<String, String> addWordToDictionary = (w, t) -> dictionary.put(w, t);

        dictionaryProcessor.processWord(word, translation, addWordToDictionary);

        Assertions.assertEquals(translation, dictionary.get(word));
    }

    @Test
    public void testProcessWordMultipleTimes() {
        dictionaryProcessor.processWord("hello", "hola", (w, t) -> dictionary.put(w, t));
        dictionaryProcessor.processWord("cat", "gato", (w, t) -> dictionary.put(w, t));
        dictionaryProcessor.processWord("teeth", "zahne", (w, t) -> dictionary.put(w, t));

        assertEquals("hola", dictionary.get("hello"));
        assertEquals("gato", dictionary.get("cat"));
        assertEquals("zahne", dictionary.get("teeth"));
    }
}