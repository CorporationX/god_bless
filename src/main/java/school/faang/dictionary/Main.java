package school.faang.dictionary;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@Slf4j
public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor(); //создал объект
        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> addWordToDictionary = (w, t) -> dictionary.put(w, t);
        //добавил слова в словарь
        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("мир", "world", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);

        //вывел словарь в консоль
        System.out.println("Словарь: " + dictionary);
        log.info("Мой словарь: " + dictionary);
    }
}