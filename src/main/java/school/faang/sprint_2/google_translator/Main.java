package school.faang.sprint_2.google_translator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addWordToDictionary = dictionary::put;

        DictiotaryProcessor.processWord("привет", "hello", addWordToDictionary);
        DictiotaryProcessor.processWord("мир", "world", addWordToDictionary);
        DictiotaryProcessor.processWord("программирование", "programming", addWordToDictionary);
        System.out.println("Словарь: " + dictionary);
    }
}
