package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Application {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addWordToDictionary = dictionary::put;

        dictionaryProcessor.processWord("Мяч", "Ball", addWordToDictionary);
        dictionaryProcessor.processWord("Вода", "Water", addWordToDictionary);
        dictionaryProcessor.processWord("Огонь", "Fire", addWordToDictionary);

        System.out.println("Словарь: " + dictionary);
    }
}