package faang.school.godbless.googletranslator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> addWordToDictionary = dictionary::put;

        DictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        DictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        DictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);

        System.out.println("dictionary: " + dictionary);
    }
}