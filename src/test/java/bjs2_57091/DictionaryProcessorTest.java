package bjs2_57091;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

class DictionaryProcessorTest {
    private DictionaryProcessor sut;
    private Map<String, String> dictionaryForTest;
    private BiConsumer<String, String> addWordToDictionary;

    @BeforeEach
    void setUp() {
        sut = new DictionaryProcessor();
        dictionaryForTest = new HashMap<>();
        addWordToDictionary = dictionaryForTest::put;
    }

    @Test
    void processWord() {
        // Arrange
        String word = "привет";
        String translation = "hello";

        // Act
        sut.processWord(word, translation, addWordToDictionary);

        // Assert
        Assertions.assertEquals(1, dictionaryForTest.size());
        Assertions.assertTrue(dictionaryForTest.containsKey(word));
        Assertions.assertEquals(translation, dictionaryForTest.get(word));
    }

    @Test
    void processSomeWords() {
        // Arrange
        String[] words = {"привет", "мир", ""};
        String[] translations = {"hello", "world", ""};

        // Act
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String translation = translations[i];

            sut.processWord(word, translation, addWordToDictionary);
        }

        // Assert
        Assertions.assertEquals(words.length, dictionaryForTest.size());
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String translation = translations[i];

            Assertions.assertTrue(dictionaryForTest.containsKey(word));
            Assertions.assertEquals(translation, dictionaryForTest.get(word));
        }
    }

    @Test
    void processWordFailedOnNullWord() {
        // Arrange
        String word = null;
        String translation = "";

        // Act + Assert
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> sut.processWord(word, translation, addWordToDictionary),
                "Аргумент 'word' не должен быть равен null");
    }
}