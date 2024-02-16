package faang.school.godbless.google;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> addWordToDictionary = dictionary::put;
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);


        System.out.println("Словарь: " + dictionary);

    }
}
