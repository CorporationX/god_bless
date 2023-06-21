package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translate, BiConsumer<String, String> translator){
        validWord(word);
        validWord(translate);
        if (translator==null){
            throw new IllegalArgumentException("TranslateConsumer cannot be null");
        }
        translator.accept(word, translate);
    }

    public void validWord(String word){
        if(word.isEmpty()){
            throw new IllegalArgumentException("Word cannot be empty");
        }
    }

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
