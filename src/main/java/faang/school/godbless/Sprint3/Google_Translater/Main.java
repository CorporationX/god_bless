package faang.school.godbless.Sprint3.Google_Translater;

import java.util.HashMap;
import java.util.Map;


public class Main {
    static Map<String, String> dictionary = new HashMap<>();

    public static void main(String[] args) {
        BiConsumer addWordToDictionary = (a, b) -> dictionary.put(a, b);

        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);

        System.out.println("Словарь: " + dictionary);
    }
}
