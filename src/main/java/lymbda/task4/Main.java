package lymbda.task4;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        BiConsumer<String, String> putToMap = (inRussian, inEnglish) -> dictionary.put(inRussian, inEnglish);
        dictionaryProcessor.processWord("яблоко", "apple", putToMap);
        dictionaryProcessor.processWord("банан", "banana", putToMap);
        dictionaryProcessor.processWord("телефон", "phone", putToMap);
        System.out.println("Словарь " + dictionary);
    }
}
