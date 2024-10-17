package module_2.module_2_1_Lambda.google_translate_33542;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String,String> dictionary = new HashMap<>();

        BiConsumer<String, String> addWordToDictionary = dictionary::put;

        dictionaryProcessor.processWord("Hello", "Привет", addWordToDictionary);
        dictionaryProcessor.processWord("world", "мир", addWordToDictionary);
        dictionaryProcessor.processWord("code", "код", addWordToDictionary);

        System.out.println("Словарь: " + dictionary);
    }
}
