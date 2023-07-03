package faang.school.godbless.google_translate;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryProcessorTest {

    @Test
    void processWord() {

        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        // Создание словаря
        Map<String, String> vocabulary = new HashMap<>();

        // Создание BiConsumer для сохранения слова и его перевода в словарь
        BiConsumer<String, String> addWordToDictionary = (word, translation) -> vocabulary.put(word, translation);

        // Добавление слов и их переводов
        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);

        Map<String, String> expectedDictionaryResult = new HashMap<>();
        expectedDictionaryResult.put("привет", "hello");
        expectedDictionaryResult.put("мир", "world");
        expectedDictionaryResult.put("программирование", "programming");

        assertEquals(expectedDictionaryResult, vocabulary);
    }
}