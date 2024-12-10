package translation;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word,
                translation);

        dictionaryProcessor.processWord("hello", "привет", addWordToDictionary);
        dictionaryProcessor.processWord("world", "мир", addWordToDictionary);
        dictionaryProcessor.processWord("programming", "программирование", addWordToDictionary);

        System.out.println("Словарь: " + dictionary);
    }
}
