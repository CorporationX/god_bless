package faang.school.godbless.google_translator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class DictionaryProcessorTest{

    @Test
    void addToDictionaryTest(){
        Map<String, String> dictionary = new HashMap<>();
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        BiConsumer<String, String> addToDictionary = (s1, s2) -> dictionary.put(s1, s2);

        String s1 = "taco";
        String s2 = "тако";
        dictionaryProcessor.processWord(s1, s2, addToDictionary);

        Assertions.assertTrue(dictionary.containsKey(s1));
        Assertions.assertTrue(dictionary.containsValue(s2));
    }
}
