package faang.school.godbless.googleTranslator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static Map<String, String> dictionary = new HashMap<>();
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);

        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);

        System.out.println("Словарь: " + dictionary);
    }
}
