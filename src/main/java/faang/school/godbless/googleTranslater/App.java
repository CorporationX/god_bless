package faang.school.godbless.googleTranslater;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class App {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);

        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("", "world", addWordToDictionary); // Неверные параметры слова
        dictionaryProcessor.processWord("программирование", null, addWordToDictionary); // Неверные параметры перевода
        dictionaryProcessor.processWord("123", "world", addWordToDictionary); // Неверные параметры слова
        dictionaryProcessor.processWord("привет", "123", addWordToDictionary); // Неверные параметры перевода

        System.out.println("Словарь: " + dictionary);
    }

}
