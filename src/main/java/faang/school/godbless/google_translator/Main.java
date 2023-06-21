package faang.school.godbless.google_translator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> addInDictionary = dictionary::put;

        DictionaryProcessor processor = new DictionaryProcessor();

        processor.processWord("привет", "hello", addInDictionary);
        processor.processWord("мир", "world", addInDictionary);
        processor.processWord("программирование", "programming", addInDictionary);

        System.out.println("Словарь: " + dictionary);
    }
}
