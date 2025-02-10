package translator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import static org.junit.jupiter.api.Assertions.*;


class DictionaryProcessorTest {
    private static final Logger log = LoggerFactory.getLogger(DictionaryProcessorTest.class);
    private DictionaryProcessor dictionaryProcessor;
    private Map<String, String> dictionary;
    private BiConsumer<String, String> addWordToDictionary;

    @BeforeEach
    void setUp() {
        dictionaryProcessor = new DictionaryProcessor();
        dictionary = new HashMap<>();
        addWordToDictionary = (word, translation) -> dictionary.put(word, translation);
    }

    @Test
    void testProcessWordValid() {
        dictionaryProcessor.processWord("рыба", "fish", addWordToDictionary);
        dictionaryProcessor.processWord("цикл", "loop", addWordToDictionary);
        dictionaryProcessor.processWord("тестирование", "testing", addWordToDictionary);

        log.info("Dictionary after adding: {}", dictionary);

        assertEquals("fish", dictionary.get("рыба"));
        assertEquals("loop", dictionary.get("цикл"));
        assertEquals("testing", dictionary.get("тестирование"));
    }

    @Test
    void testProcessWordWithNullWord() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                dictionaryProcessor.processWord(null, "hello", addWordToDictionary)
        );
        assertTrue(exception.getMessage().contains("must not be null"));
    }

    @Test
    void testProcessWordWithNullTranslation() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                dictionaryProcessor.processWord("привет", null, addWordToDictionary)
        );
        assertTrue(exception.getMessage().contains("must not be null"));
    }

    @Test
    void testProcessWordWithNullConsumer() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                dictionaryProcessor.processWord("привет", "hello", null)
        );
        assertTrue(exception.getMessage().contains("must not be null"));
    }

    @Test
    void testProcessWordConsumerThrowsException() {
        BiConsumer<String, String> faultyConsumer = (word, translation) -> {
            throw new RuntimeException("User error");
        };

        DictionaryProcessingException exception = assertThrows(DictionaryProcessingException.class, () ->
                dictionaryProcessor.processWord("привет", "hello", faultyConsumer)
        );
        assertTrue(exception.getMessage().contains("Error processing word"));
    }
}
