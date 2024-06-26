package faang.school.godbless.Sprint_2.Lamdas.BJS2_9626;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        // Создание словаря
        Map<String, String> dictionary = new HashMap<>();

// Создание BiConsumer для сохранения слова и его перевода в словарь
        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);

// Добавление слов и их переводов
        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("Да", "Yes", addWordToDictionary);
        dictionaryProcessor.processWord("Нет", "Not", addWordToDictionary);
        dictionaryProcessor.processWord("Биба", "Biba", addWordToDictionary);

        dictionary.forEach((key, value) -> System.out.println(key + " - " + value));
    }
}
