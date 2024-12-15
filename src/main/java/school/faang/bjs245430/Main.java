package school.faang.bjs245430;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);
        // BiConsumer<String, String> addWordToDictionary = dictionary::put;

        dictionaryProcessor.processWord("разработка", "developing", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);
        System.out.println("Словарь: " + dictionary);
    }
}