package faang.school.godbless.translator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> dictionaryMap = new HashMap<>();

        BiConsumer<String, String> addWordInDictionary = (word, translation) -> {
            if (word != null && translation != null) {
                dictionaryMap.putIfAbsent(word, translation);
            }
        };

        dictionaryProcessor.processWord("hello", "привет", addWordInDictionary);
        dictionaryProcessor.processWord("goodbye", "пока", addWordInDictionary);
        dictionaryProcessor.processWord(null, "пока", addWordInDictionary);
        dictionaryProcessor.processWord("goodbye", null, addWordInDictionary);

        System.out.println(dictionaryMap);
    }
}
