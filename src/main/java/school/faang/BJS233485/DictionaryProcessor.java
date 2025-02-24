package school.faang.BJS233485;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String wordMeaning, BiConsumer<String, String> consumer) {
       consumer.accept(word, wordMeaning);
    }

    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

// Создание словаря
        Map<String, String> dictionary = new HashMap<>();

// Лямбда-выражение для добавления слова и его перевода в словарь
        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);

// Добавление слов и их переводов
        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);

// Выводим словарь
        dictionary.forEach((word, meaning) -> System.out.println(word + " : " + meaning));
    }
}
