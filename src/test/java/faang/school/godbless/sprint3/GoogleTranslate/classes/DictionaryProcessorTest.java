package faang.school.godbless.sprint3.GoogleTranslate.classes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryProcessorTest {
    private static final String EMPTY_STRING = "";
    private static Map<String, String> dictionary = new HashMap<>();
    private static DictionaryProcessor dictionaryProcessor;

    private static BiConsumer<String, String> consumer;

    @BeforeAll
    static void setUp() {
        dictionaryProcessor = new DictionaryProcessor();
        consumer = (word, translate) -> dictionary.put(word, translate);
    }

    @ParameterizedTest
    @MethodSource("getWords")
    @DisplayName("Correct work test")
    void processWord_functionPutWordInMap(String word, String translate) {
        dictionaryProcessor.processWord(word, translate, consumer);
        assertAll(
                () -> assertTrue(dictionary.containsKey(word)),
                () -> assertTrue(dictionary.containsValue(translate))
        );
    }

    @Test
    @DisplayName("Word is null")
    void processWord_wordIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> dictionaryProcessor.processWord(null, "blank", consumer));
        assertEquals(DictionaryProcessor.NULLABLE_VALUE_EXCEPTION, exception.getMessage());
    }

    @Test
    @DisplayName("Word is empty")
    void processWord_wordIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> dictionaryProcessor.processWord(EMPTY_STRING, "blank", consumer));
        assertEquals(DictionaryProcessor.EMPTY_VALUE_EXCEPTION, exception.getMessage());
    }

    @Test
    @DisplayName("Translate is null")
    void processWord_translateIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> dictionaryProcessor.processWord("blank", null, consumer));
        assertEquals(DictionaryProcessor.NULLABLE_VALUE_EXCEPTION, exception.getMessage());
    }

    @Test
    @DisplayName("Translate is empty")
    void processWord_translateIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> dictionaryProcessor.processWord("blank", EMPTY_STRING, consumer));
        assertEquals(DictionaryProcessor.EMPTY_VALUE_EXCEPTION, exception.getMessage());
    }

    private static Stream<Arguments> getWords() {
        return Stream.of(
                Arguments.of(
                        "Hello", "Привет"
                ),
                Arguments.of(
                        "Night", "Ночь"
                ),
                Arguments.of(
                        "Word", "Слово"
                ),
                Arguments.of(
                        "Dark", "Тьма"
                )
        );
    }
}