package BJS2_9502;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();

        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        BiConsumer<String, String> addWordToDictionary = dictionary::put;

        dictionaryProcessor.processWord("apple", "яблоко", addWordToDictionary);
        dictionaryProcessor.processWord("google", "гугл", addWordToDictionary);
        dictionaryProcessor.processWord("microsoft", "мелко-мягкий", addWordToDictionary);

        dictionary.forEach((key, value) -> System.out.println(key + " " + value));
    }
}