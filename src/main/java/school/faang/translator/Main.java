package school.faang.translator;

import java.util.HashMap;
import java.util.function.BiConsumer;

/**
 * @author Danil Pudovkin
 * @since 11.06.2025
 */
public class Main {

    public static void main(String[] args) {
        var dictionaryProcessor = new DictionaryProcessor();
        var dictionary = new HashMap<String, String>();

        var addWordToDictionary = (BiConsumer<String, String>) dictionary::put;

        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);

        System.out.println("Словарь: " + dictionary);
    }
}
