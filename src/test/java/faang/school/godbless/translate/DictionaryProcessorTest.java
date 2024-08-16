package faang.school.godbless.translate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DictionaryProcessorTest {

    @DisplayName("should add words to dictionary")
    @Test
    public void testDictionaryProcessor() {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String, String> ruEnDictionary = new HashMap<>();
        Map<String, String> ruSpDictionary = new HashMap<>();
        BiConsumer<String, String> addRuEn = ruEnDictionary::put;
        BiConsumer<String, String> addRuSp = ruSpDictionary::put;

        dictionaryProcessor.processWord("привет", "hello", addRuEn);
        dictionaryProcessor.processWord("мир", "world", addRuEn);
        dictionaryProcessor.processWord("привет", "hola", addRuSp);
        dictionaryProcessor.processWord("мир", "mundo", addRuSp);

        assertEquals("{мир=world, привет=hello}", ruEnDictionary.toString());
        assertEquals("{мир=mundo, привет=hola}", ruSpDictionary.toString());
    }

}