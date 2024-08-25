package faang.school.godbless.translator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {

    public static void main(String[] args) {

        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> rusEngDictionary = new HashMap<>();
//        BiConsumer<String, String> addTranslation = (word, translation) -> engRusDictionary.put(word, translation);

        // Better, based on the actual object
        BiConsumer<String, String> addTranslation = rusEngDictionary::put;

        dictionaryProcessor.processWord("привет", "hello", addTranslation);
        dictionaryProcessor.processWord("мир", "world", addTranslation);
        dictionaryProcessor.processWord("программирование", "programming", addTranslation);

        System.out.println("Словарь: " + rusEngDictionary);
    }
}
