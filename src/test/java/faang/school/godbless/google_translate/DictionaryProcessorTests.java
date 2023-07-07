package faang.school.godbless.google_translate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

public class DictionaryProcessorTests {

    private DictionaryProcessor dictionaryProcessor;
    private BiConsumer<String, String> addWordToDictionary;

    public void setUp() {
        dictionaryProcessor = new DictionaryProcessor();
        addWordToDictionary = (word, translation) -> dictionaryProcessor.getDictionary().put(word, translation);
    }

    @Test
    @DisplayName("Should add pair to dictionary")
    public void shouldAddPairToDictionary() {
        dictionaryProcessor.processWord("поток", "stream", addWordToDictionary);
        dictionaryProcessor.processWord("нить", "thread", addWordToDictionary);
        dictionaryProcessor.processWord("список", "list", addWordToDictionary);

        Assertions.assertEquals(3, dictionaryProcessor.getDictionary().size());
        Assertions.assertEquals("thread", dictionaryProcessor.getDictionary().get("нить"));
    }
}
