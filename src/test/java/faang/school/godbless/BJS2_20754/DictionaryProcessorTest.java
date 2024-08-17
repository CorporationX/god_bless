package faang.school.godbless.BJS2_20754;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static org.assertj.core.api.Assertions.assertThat;

class DictionaryProcessorTest {
    private DictionaryProcessor dp;
    private Map<String, String> dictionary;
    private BiConsumer<String, String> addWordToDictionary;

    @BeforeEach
    void setUp() {
        dp = new DictionaryProcessor();
        dictionary = new HashMap<>();
        addWordToDictionary = (word, translate) -> dictionary.put(word, translate);
    }

    @Test
    void processWord() {
        dp.processWord("привет", "hello", addWordToDictionary);
        dp.processWord("мир", "world", addWordToDictionary);
        dp.processWord("программирование", "programming", addWordToDictionary);

        assertThat(dictionary).containsKeys("привет", "мир", "программирование").hasSize(3);
        assertThat(dictionary.get("привет")).isEqualTo("hello");
        assertThat(dictionary.get("мир")).isEqualTo("world");
        assertThat(dictionary.get("программирование")).isEqualTo("programming");
    }
}