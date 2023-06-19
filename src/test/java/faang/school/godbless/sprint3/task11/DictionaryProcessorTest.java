package faang.school.godbless.sprint3.task11;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryProcessorTest {

    @Test
    void testProcessWord() {
        Map<String, String> map = new HashMap<>();
        BiConsumer<String, String> biConsumer = map::put;
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        dictionaryProcessor.processWord("привет", "hello", biConsumer);

        assertEquals("hello", map.get("привет"));
    }

    @Test
    void testValidationIsNull() {
        assertThrows(NullPointerException.class,
                () -> new DictionaryProcessor().processWord("c", "c", null));
    }

    @Test
    void testValidationIsNegativeNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> new DictionaryProcessor().processWord("  ", "", new HashMap<>()::put));
    }
}