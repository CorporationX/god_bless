package google;

import faang.school.godbless.google.DictionaryProcessor;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DictionaryProcessorTest {
  @Test
  public void processWordTest() {
    Map<String, String> expectedDictionaryResult = new HashMap<>();
    expectedDictionaryResult.put("привет", "hello");
    expectedDictionaryResult.put("мир", "world");
    expectedDictionaryResult.put("программирование", "programming");

    DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

    // Создание словаря
    Map<String, String> dictionary = new HashMap<>();

    // Создание BiConsumer для сохранения слова и его перевода в словарь
    BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);

    // Добавление слов и их переводов
    dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
    dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
    dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);

    assertEquals(expectedDictionaryResult, dictionary);
  }
}
