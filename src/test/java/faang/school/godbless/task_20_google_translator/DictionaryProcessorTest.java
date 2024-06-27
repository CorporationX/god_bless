package faang.school.godbless.task_20_google_translator;

import faang.school.godbless.sprint_2.functional_interface.task_20_google_translator.DictionaryProcessor;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DictionaryProcessorTest {
    @Test
    public void testProcessWord(){
        // Arrange
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> biConsumer = dictionary::put;
        String word = "word";
        String translation = "слово";

        // Act
        dictionaryProcessor.processWord(word, translation, biConsumer);
        // Assert
        assertTrue(dictionary.containsKey(word), "добавление в словарь не произошло");
        assertEquals(translation, dictionary.get(word), "неверное значение в словаре");

    }
}
