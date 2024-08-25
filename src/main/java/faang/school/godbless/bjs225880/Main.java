package faang.school.godbless.bjs225880;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addToDictionary = dictionary::put;

        dictionaryProcessor.processWord("Perro", "Собака", addToDictionary);
        dictionaryProcessor.processWord("Gato", "Кот", addToDictionary);

        System.out.println(dictionary);
    }
}