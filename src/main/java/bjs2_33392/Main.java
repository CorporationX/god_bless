package bjs2_33392;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        BiConsumer<String, String> translator = (originalWord, translatedWord) ->
                dictionary.put(originalWord, translatedWord);

        dictionaryProcessor.processWord("Привет", "Hello", translator);
        dictionaryProcessor.processWord("Лев", "Lion", translator);

        System.out.println(dictionary);
    }
}
