package faang.school.godbless.Google_Translator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();

        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        BiConsumer<String, String> saveWordToDictionary = dictionary::put;

        dictionaryProcessor.processWord("привет", "hello", saveWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", saveWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", saveWordToDictionary);

        System.out.println("Словарь: " + dictionary);
    }
}