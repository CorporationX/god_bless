package faang.school.godbless.alexbulgakoff.functionalinterfaceslambdas.googletranslate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author Alexander Bulgakov
 */

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();

        Map<String, String> userDictionary = new HashMap<>();

        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);
        BiConsumer<String, String> addWordToUserDictionary = (word, translation) -> userDictionary.put(word, translation);

        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);

        dictionaryProcessor.processWord("функциональный интерфейс", "functional interface", addWordToUserDictionary);
        dictionaryProcessor.processWord("внутренний класс", "inner class", addWordToUserDictionary);
        dictionaryProcessor.processWord("многопоточность", "multithreading", addWordToUserDictionary);

        System.out.println("Словарь: " + dictionary);
        System.out.println("Словарь пользователя: " + userDictionary);
    }
}
