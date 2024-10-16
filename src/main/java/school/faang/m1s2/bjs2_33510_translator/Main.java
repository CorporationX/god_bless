package school.faang.m1s2.bjs2_33510_translator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addWordToDictionary = dictionary::put;

        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);
        dictionaryProcessor.processWord("ява", "java", addWordToDictionary);
        dictionaryProcessor.processWord("питон", "python", addWordToDictionary);

        System.out.println("Словарь: " + dictionary);
    }
}
