package faang.school.godbless.sprint_3.google_translator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryProcessorTest {
    DictionaryProcessor processor;
    BiConsumer<String, String> addWord;

    @BeforeEach
    void init() {
        processor = new DictionaryProcessor();
        addWord = (writeWord, writeTranslate) -> processor.dictionary.put(writeWord, writeTranslate);
    }

    @ParameterizedTest
    @CsvSource({"table, стол"})
    void processWordFirstScenarioTest(String word, String translate) {
        processor.processWord(word, translate, addWord);

        String result = processor.dictionary.get(word);

        assertEquals(translate, result);
    }

    @ParameterizedTest
    @CsvSource({", стол"})
    void testProcessWordWithNullWordThrowException(String word, String translate) {
        assertThrows(IllegalArgumentException.class, () -> processor.processWord(word, translate, addWord));
    }

    @ParameterizedTest
    @CsvSource({"home,"})
    void testProcessWordWithNullTranslationThrowException(String word, String translate) {
        assertThrows(IllegalArgumentException.class, () -> processor.processWord(word, translate, addWord));
    }

    @ParameterizedTest
    @CsvSource({"  , дом"})
    void testProcessWordWithEmptyWordThrowException(String word, String translate) {
        assertThrows(IllegalArgumentException.class, () -> processor.processWord(word, translate, addWord));
    }

    @ParameterizedTest
    @CsvSource({"home,  "})
    void testProcessWordWithEmptyTranslationThrowException(String word, String translate) {
        assertThrows(IllegalArgumentException.class, () -> processor.processWord(word, translate, addWord));
    }

    @ParameterizedTest
    @CsvSource({"home, дом"})
    void testProcessWordWithNullAddWordThrowException(String word, String translate) {
        assertThrows(IllegalArgumentException.class, () -> processor.processWord(word, translate, null));
    }
}
