package school.faang.google;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addWordToDictionary = (word, transtation) -> dictionary.put(word, transtation);

        dictionaryProcessor.processWord("Hat", "Шляпа", addWordToDictionary);
        dictionaryProcessor.processWord("Table", "Стол", addWordToDictionary);
        dictionaryProcessor.processWord("Hello", "Привет", addWordToDictionary);

        System.out.println("Dictionary" + dictionary);
    }
}
