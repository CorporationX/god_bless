package faang.school.godbless.lambda.google_translate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addWordToDictionary = (original, transale) -> dictionary.put(original, transale);

        dictionaryProcessor.processWord("Hello", "Привет", addWordToDictionary);
        dictionaryProcessor.processWord("Home", "Дом", addWordToDictionary);

        System.out.println(dictionary);
    }
}
