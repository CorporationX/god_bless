package faang.school.godbless.lambda_stream.google_translate;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryProcessorTest {

    @Test
    void testProcessWord() {
        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);

        DictionaryProcessor.processWord("������", "hello", addWordToDictionary);
        DictionaryProcessor.processWord("���", "world", addWordToDictionary);
        DictionaryProcessor.processWord("����������������", "programming", addWordToDictionary);

        assertEquals(3, dictionary.size());
        assertTrue(dictionary.containsKey("������"));
        assertEquals("hello", dictionary.get("������"));
    }
}