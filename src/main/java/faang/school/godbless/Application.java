package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Application {
    public static void main(String... args) {

        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

// Создание словаря
        Map<String, String> dictionary = new HashMap<>();

// Создание BiConsumer для сохранения слова и его перевода в словарь
        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);

// Добавление слов и их переводов
        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);

        System.out.println("Словарь: " + dictionary);

    }
}
