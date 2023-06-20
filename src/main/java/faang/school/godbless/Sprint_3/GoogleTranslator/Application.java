package faang.school.godbless.Sprint_3.GoogleTranslator;

import java.util.HashMap;

import java.util.Map;

import java.util.function.BiConsumer;

public class Application {
    public static void main(String... args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);

        dictionaryProcessor.processWord("бутылка", "bottle", addWordToDictionary);
        dictionaryProcessor.processWord("игра", "game", addWordToDictionary);
        dictionaryProcessor.processWord("программирование", "programming", addWordToDictionary);

        System.out.println("Словарь: " + dictionary);

    }
}
