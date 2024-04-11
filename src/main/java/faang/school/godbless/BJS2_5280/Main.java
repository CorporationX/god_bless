package faang.school.godbless.BJS2_5280;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        // Создание словаря
        Map<String, String> dictionary = new HashMap<>();

        // Создание BiConsumer для сохранения слова и его перевода в словарь
        BiConsumer<String, String> addWordToDictionary = dictionary::put;

        // Добавление слов и их переводов
        dictionaryProcessor.processWord("мне нравится", "me peache", addWordToDictionary);
        dictionaryProcessor.processWord("есть", "mangare", addWordToDictionary);
        dictionaryProcessor.processWord("пить", "berre", addWordToDictionary);

        System.out.println("Словарь: " + dictionary);
    }
}
