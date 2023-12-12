package faang.school.godbless.google_translater;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addWordDictionary = (word, translation) -> dictionary.put(word, translation);

        dictionaryProcessor.processWord("привет", "hello", addWordDictionary);
        dictionaryProcessor.processWord("мир", "word", addWordDictionary);
        dictionaryProcessor.processWord("программировние", "programming", addWordDictionary);
        dictionaryProcessor.processWord("ложь", "false", addWordDictionary);

        System.out.println("словарь" + dictionary);
    }
}