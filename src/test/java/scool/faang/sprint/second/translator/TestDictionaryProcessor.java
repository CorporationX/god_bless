package scool.faang.sprint.second.translator;


import org.junit.Test;
import org.mockito.Mockito;
import school.faang.sprint.second.translator.DictionaryProcessor;
import school.faang.sprint.second.translator.WordBlankException;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class TestDictionaryProcessor {
    @Test
    public void testProcessWord() {
        DictionaryProcessor processor = Mockito.mock(DictionaryProcessor.class);

        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> biConsumer = dictionary::put;
        processor.processWord("Привет", "Hello", biConsumer);

        Mockito.verify(processor, Mockito.times(1)).processWord("Привет", "Hello", biConsumer);
    }

    @Test(expected = WordBlankException.class)
    public void testProcessBlankWord() {
        DictionaryProcessor processor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> biConsumer = dictionary::put;
        processor.processWord("", "Hello", biConsumer);
    }

    @Test(expected = WordBlankException.class)
    public void testProcessBlankTranslatedWord() {
        DictionaryProcessor processor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> biConsumer = dictionary::put;
        processor.processWord("Привет", "", biConsumer);
    }

    @Test(expected = NullPointerException.class)
    public void testProcessNullWords() {
        DictionaryProcessor processor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> biConsumer = dictionary::put;
        processor.processWord(null, null, biConsumer);
    }
}
