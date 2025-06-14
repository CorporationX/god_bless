package school.faang.bjs2_79999;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addWordToDictionary = dictionary::put;

        dictionaryProcessor.processorWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processorWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processorWord("программирование", "programming", addWordToDictionary);

        System.out.println("Словарь: " + dictionary);
    }
}
