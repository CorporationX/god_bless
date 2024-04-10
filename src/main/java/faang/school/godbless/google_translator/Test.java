package faang.school.godbless.google_translator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Test {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();

        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);

        dictionaryProcessor.processWord("Hello", "Привет", addWordToDictionary);

        System.out.println(dictionary);
    }
}
