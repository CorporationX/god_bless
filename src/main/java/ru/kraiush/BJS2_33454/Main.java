package ru.kraiush.BJS2_33454;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {

    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addWordAndTranslationToDictionary = (word, translation) -> dictionary.put(word, translation);

        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        dictionaryProcessor.processWord("программирование", "programming", addWordAndTranslationToDictionary);
        dictionaryProcessor.processWord("реализация", "implementation", addWordAndTranslationToDictionary);
        dictionaryProcessor.processWord("расширять", "extend", addWordAndTranslationToDictionary);

        System.out.println("Dictionary: " + dictionary);
    }
}
