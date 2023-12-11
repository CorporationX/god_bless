package faang.school.godbless.google;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String... args) {
        Map<String, String> dictionary = new HashMap<>();

        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);

        dictionaryProcessor.processWord("wood", "лес", addWordToDictionary);
        dictionaryProcessor.processWord("array", "массив", addWordToDictionary);
        dictionaryProcessor.processWord("among", "среди", addWordToDictionary);
        dictionaryProcessor.processWord("suggest", "предлагать", addWordToDictionary);
        System.out.println("Dictionary: " + dictionary);

    }
}
