package faang.school.godbless.googletranslator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    private final static Map<String, String> dictionary = new HashMap<>();
    public static void startGoogleTranslator() {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        BiConsumer<String, String> addWordToDictionary = ((word, translation) -> dictionary.put(word, translation));
        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);

        System.out.println("Словарь: " + dictionary);
    }
}
