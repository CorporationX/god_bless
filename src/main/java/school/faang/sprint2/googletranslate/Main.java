package school.faang.sprint2.googletranslate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);

        dictionaryProcessor.processWord("Привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("Мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("Программирование", "programming", addWordToDictionary);
        System.out.println("Словарь: " + dictionary);


    }
}
