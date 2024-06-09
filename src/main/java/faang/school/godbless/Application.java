package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Application {

    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> addWordToDictionary = dictionary::put;
        dictionaryProcessor.processWord("Привет", "Hello", addWordToDictionary);
        dictionaryProcessor.processWord("Небо", "Sky", addWordToDictionary);
        dictionaryProcessor.processWord("Трава", "Grass", addWordToDictionary);
        dictionaryProcessor.processWord("Нравится", "Like", addWordToDictionary);
        System.out.println(dictionary);
    }
}