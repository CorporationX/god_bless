package faang.school.godbless.secondSprint.GoogleTranslator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String,String> dictionary = new HashMap<>();
        BiConsumer<String, String> biConsumer = dictionary::put;

        dictionaryProcessor.processWord("apple", "яблоко", biConsumer);
        dictionaryProcessor.processWord("orange", "апельсин", biConsumer);
        dictionaryProcessor.processWord("banana", "банан", biConsumer);

        System.out.println(dictionary);
    }
}
