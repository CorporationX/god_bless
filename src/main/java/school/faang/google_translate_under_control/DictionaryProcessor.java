package school.faang.google_translate_under_control;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);
        processWord("привет", "hello", addWordToDictionary);
        processWord("мир", "world", addWordToDictionary);
        processWord("программирование", "programming", addWordToDictionary);
        System.out.println("Dictionary: " + dictionary);
    }

    public static void processWord(String word, String translation, BiConsumer<String, String> addWordToDictionary) {
        addWordToDictionary.accept(word, translation);
    }
}