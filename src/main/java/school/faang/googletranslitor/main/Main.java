package school.faang.googletranslitor.main;

import school.faang.googletranslitor.maincode.DictionaryProcessor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String,String> addWordToDictionary =
                (word, translation) -> dictionary.put(word, translation);

        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("пока", "bye", addWordToDictionary);

        System.out.println("словарь " + dictionary);
    }
}