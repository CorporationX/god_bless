package Sprint_2.BJS2_33533;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> dictionaryAction) {
        dictionaryAction.accept(word, translation);
    }

    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addWordToDictionary = (word, translation) -> dictionary.put(word, translation);

        dictionaryProcessor.processWord("привет", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("всем", "all", addWordToDictionary);
        dictionaryProcessor.processWord("друзья", "friends", addWordToDictionary);

        System.out.println("Словарь: " + dictionary);

    }
}
