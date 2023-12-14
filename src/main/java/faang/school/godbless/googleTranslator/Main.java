package faang.school.godbless.googleTranslator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addWordToDictionary = (word, translate) -> dictionary.put(word,translate);

        dictionaryProcessor.processWord("привет", "hello",addWordToDictionary);
        dictionaryProcessor.processWord("пока", "bye",addWordToDictionary);
        dictionaryProcessor.processWord("удачи", "good luck",addWordToDictionary);

        System.out.println("Словарь: " + dictionary);
    }
}
