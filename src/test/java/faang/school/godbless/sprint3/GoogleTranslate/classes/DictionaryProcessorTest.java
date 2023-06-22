package faang.school.godbless.sprint3.GoogleTranslate.classes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
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
    private static final String NULL_STRING = null;
    private static final Map<String, String> dictionary = new HashMap<>();
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

    @ParameterizedTest
    @MethodSource("getEmptyOrNullString")
    @DisplayName("Word is null or empty")
    void processWord_WordIsNullOrEmpty(String word) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> dictionaryProcessor.processWord(word, "some", consumer));
        assertEquals(DictionaryProcessor.WORD_IS_EMPTY_OR_NULL, exception.getMessage());
    }

    @ParameterizedTest
    @MethodSource("getEmptyOrNullString")
    @DisplayName("Translate word is null or empty")
    void processWord_TranslateIsNullOrEmpty(String word) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> dictionaryProcessor.processWord("some", word, consumer));
        assertEquals(DictionaryProcessor.TRANSLATE_IS_EMPTY_OR_NULL, exception.getMessage());
    }

    public static Stream<Arguments> getEmptyOrNullString() {
        return Stream.of(
                Arguments.of(EMPTY_STRING),
                Arguments.of(NULL_STRING)
        );
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