package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        // Создание словаря.
        Map<String, String> dictionary = new HashMap<>();

        // Создание BiConsumer для сохранения слова и его перевода в слооварь.
        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);

        // Добавление слов и их переводов.
        dictionaryProcessor.processWord("Привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("Мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("Программирование", "programming", addWordToDictionary);

        System.out.println("Словарь: " + dictionary) ;
    }
}
