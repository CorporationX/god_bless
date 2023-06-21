package faang.school.godbless.googleTranslator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();
        Map<String, String> dictionaryOfVlad = new HashMap<>();

        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);
        BiConsumer<String, String> addWordToDictionaryOfVlad = (word, translation) -> dictionaryOfVlad.put(word, translation);

        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionaryOfVlad);

        System.out.println("Словарь: " + dictionary);
        System.out.println("Словарь: " + dictionaryOfVlad);
    }
}
