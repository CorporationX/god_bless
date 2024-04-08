package googleTranslate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        BiConsumer<String, String> addWordIntoDictionary = (word, translation) -> dictionary.put(word, translation);

        dictionaryProcessor.processWord("car", "машина", addWordIntoDictionary);
        dictionaryProcessor.processWord("city", "город", addWordIntoDictionary);
        dictionaryProcessor.processWord("water", "вода", addWordIntoDictionary);

        System.out.println("Словарь: " + dictionary);
    }
}
