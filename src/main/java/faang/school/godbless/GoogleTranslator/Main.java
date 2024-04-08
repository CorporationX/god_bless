package faang.school.godbless.GoogleTranslator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addWordToDictionary = dictionary::put;

        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);
        dictionaryProcessor.processWord("собака", "dog", addWordToDictionary);
        dictionaryProcessor.processWord("кошка", "cat", addWordToDictionary);

        System.out.println("Словарь: ");
        dictionary.forEach((word, translation) -> System.out.println(word + " -> " + translation));
    }
}
