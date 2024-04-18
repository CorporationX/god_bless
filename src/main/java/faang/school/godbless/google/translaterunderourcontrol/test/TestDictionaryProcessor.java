package faang.school.godbless.google.translaterunderourcontrol.test;

import faang.school.godbless.google.translaterunderourcontrol.DictionaryProcessor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class TestDictionaryProcessor {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> translationProcessor = dictionary::put;

        dictionaryProcessor.processWord("game", "игра", translationProcessor);
        dictionaryProcessor.processWord("health", "здоровье", translationProcessor);
        dictionaryProcessor.processWord("employment", "трудоустройство", translationProcessor);

        dictionary.forEach((word, translation) -> System.out.printf("\t\tword: %s, translation: %s \n", word, translation));
    }
}
