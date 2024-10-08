package google_translator_is_under_our_control;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DictionaryProcessorTest {
    private final DictionaryProcessor DICTIONARY_PROCESSOR = new DictionaryProcessor();
    private final Map<String, String> DICTIONARY = new HashMap<>();

    private final BiConsumer<String, String> ADD_WORD_TO_DICTIONARY = DICTIONARY::put;

    @Test
    void processWord() {
        DICTIONARY_PROCESSOR.processWord("привет", "hello", ADD_WORD_TO_DICTIONARY);

        assertEquals("{hello=привет}", DICTIONARY);
    }
}