package faang.school.godbless;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class Application {
    public static void main(String... args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> addWordToDictionary = dictionary::put;
        dictionaryProcessor.processWord("Салам", "Salam", addWordToDictionary);
        System.out.printf("Словарь " + dictionary);
    }
}
