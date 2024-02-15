package lymbda.task4;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        BiConsumer<String, String> biConsumer = (inRussian, inEnglish) -> dictionary.put(inRussian, inEnglish);
        dictionaryProcessor.processWord("яблоко", "apple", biConsumer);
        dictionaryProcessor.processWord("банан", "banana", biConsumer);
        dictionaryProcessor.processWord("телефон", "phone", biConsumer);
        System.out.println("Словарь " + dictionary);
    }
}
