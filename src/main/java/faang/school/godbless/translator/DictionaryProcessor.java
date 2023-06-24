package faang.school.godbless.translator;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(word, translation);
    }

    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);

        dictionaryProcessor.processWord("Hello", "Привет", addWordToDictionary);
        dictionaryProcessor.processWord("Bye", "пока", addWordToDictionary);

        System.out.println("Словарь: " + dictionary);
    }
}
