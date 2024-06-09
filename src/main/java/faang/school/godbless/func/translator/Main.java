package faang.school.godbless.func.translator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {

    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> addWordToDictionary = dictionary::put;

        dictionaryProcessor.processWord("red", "красный", addWordToDictionary);
        dictionaryProcessor.processWord("blue", "синий", addWordToDictionary);
        dictionaryProcessor.processWord("green", "зеленый", addWordToDictionary);

        System.out.println(dictionary);
    }
}
