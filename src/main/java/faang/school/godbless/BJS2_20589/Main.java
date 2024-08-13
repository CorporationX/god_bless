package faang.school.godbless.BJS2_20589;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addToDictionary = (word, translation) -> dictionary.put(word, translation);

        dictionaryProcessor.processWord("яблоко", "apple", addToDictionary);
        dictionaryProcessor.processWord("машина", "car", addToDictionary);
        dictionaryProcessor.processWord("собака", "dog", addToDictionary);

        System.out.println(dictionary);
    }
}
