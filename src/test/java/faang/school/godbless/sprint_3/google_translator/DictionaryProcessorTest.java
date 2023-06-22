package faang.school.godbless.sprint_3.google_translator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryProcessorTest {
    DictionaryProcessor processor;
    BiConsumer<String, String> addWord;

    @BeforeEach
    void init() {
        processor = new DictionaryProcessor();
        addWord = ((word, translate) -> DictionaryProcessor.dictionary.put(word, translate));
    }

    @Test
    void processWordTest() {
        processor.processWord("table", "стол", addWord);
        processor.processWord("home", "дом", addWord);

        String expected = "стол";
        String result = DictionaryProcessor.dictionary.get("table");

        assertTrue(DictionaryProcessor.dictionary.containsKey("home"));
        assertEquals(2, DictionaryProcessor.dictionary.size());
        assertEquals(expected, result);
    }

    @Test
    void processWordThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> processor.processWord(null, null, null));
        assertThrows(IllegalArgumentException.class, () -> processor.processWord("   ", "", addWord));
    }
}
