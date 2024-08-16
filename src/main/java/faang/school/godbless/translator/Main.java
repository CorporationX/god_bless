package faang.school.godbless.translator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addWordInDictionary = (word, wordTranslation) -> {
            if (word != null && wordTranslation != null) {
                dictionary.putIfAbsent(word, wordTranslation);
            }
        };

        dictionaryProcessor.processWord("hello", "привет", addWordInDictionary);
        dictionaryProcessor.processWord("goodbye", "пока", addWordInDictionary);
        dictionaryProcessor.processWord(null, "пока", addWordInDictionary);
        dictionaryProcessor.processWord("goodbye", null, addWordInDictionary);

        System.out.println(dictionary);
    }
}
