package faang.school.godbless.googleTranslator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class CheckTranslation {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        // Создание словаря
        Map<String, String> dictionary = new HashMap<>();

        // Создание BiConsumer для сохранения слова и его перевода в словарь
        BiConsumer<String, String> addWordToDictionary = dictionary::put;

        // Добавление слов и их переводов
        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);

        System.out.println("Словарь: " + dictionary);
    }
}
