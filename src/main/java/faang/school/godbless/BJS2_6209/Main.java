package faang.school.godbless.BJS2_6209;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> addWordToDictionary = dictionary::put;

        dictionaryProcessor.processWord("privet", "hello", addWordToDictionary);
        dictionaryProcessor.processWord("mir", "world", addWordToDictionary);
        dictionaryProcessor.processWord("programmirovanie", "programming", addWordToDictionary);

        System.out.println("Dictionary: " + dictionary);
    }
}
