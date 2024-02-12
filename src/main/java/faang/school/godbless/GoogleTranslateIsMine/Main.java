package faang.school.godbless.GoogleTranslateIsMine;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {

    static Map<String, String> dictionary = new HashMap<>();

    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        BiConsumer<String, String> addWordToDictionary = (word1, word2) -> dictionary.put(word1, word2);
        dictionaryProcessor.processWord("Milk", "Молоко", addWordToDictionary);
        dictionaryProcessor.processWord("Bird", "Птичкъ", addWordToDictionary);
        dictionaryProcessor.processWord("Rambunctious", "Буйный", addWordToDictionary);
        System.out.println(dictionary);
    }
}