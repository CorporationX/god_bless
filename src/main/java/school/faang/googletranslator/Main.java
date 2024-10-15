package school.faang.googletranslator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {

        Map<String, String> dictionary = new HashMap<>();

        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor(dictionary);

        BiConsumer<String, String> addWordToDictionary = dictionary::put;

        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);

        System.out.println("Dictionary: " + dictionary);
    }
}
